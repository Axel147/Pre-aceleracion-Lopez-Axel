package com.disney.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.builder.GeneroBuilder;
import com.disney.builder.MetrajeBuilder;
import com.disney.builder.PersonajeBuilder;
import com.disney.dto.GeneroDTO;
import com.disney.dto.MetrajeDTO;
import com.disney.dto.MetrajeImaTitFecDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.model.Genero;
import com.disney.model.Metraje;
import com.disney.model.Personaje;
import com.disney.repository.GeneroRepository;
import com.disney.repository.MetrajeRepository;
import com.disney.repository.PersonajeRepository;
import com.disney.service.IMetrajeService;

@Service
public class MetrajeServiceImpl implements IMetrajeService{
	@Autowired
	private MetrajeRepository metrajeRepository;
	@Autowired
	private PersonajeRepository personajeRepository;
	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public MetrajeImaTitFecDTO obtenerMetraje(Long id) {
		Metraje metraje = metrajeRepository.getById(id);
		MetrajeImaTitFecDTO metrajeImaTitFecDTO = new MetrajeBuilder().imaTitFecWithMetraje(metraje).buildImaTitFecMetrajeImaTitFecDTO();
		
		return metrajeImaTitFecDTO;
	}
	@Override
	public List<MetrajeImaTitFecDTO> obtenerMetrajes() {
		List<MetrajeImaTitFecDTO> listaFinal = new ArrayList<>();
		for(Metraje metrajesRegistrados : metrajeRepository.findAll()) {
			MetrajeImaTitFecDTO metrajeImaTitFecDTO= new MetrajeBuilder().imaTitFecWithMetraje(metrajesRegistrados).buildImaTitFecMetrajeImaTitFecDTO();
			
			listaFinal.add(metrajeImaTitFecDTO);
		}	
		return listaFinal;
	}
	
	
	@Override
	public Metraje insertarMetraje(MetrajeDTO metrajeDTO) {
		Metraje metraje = new MetrajeBuilder().withMetrajeDTO(metrajeDTO).build();
		boolean tieneGenero = false;
		boolean tienePersonaje = false;
		List<Personaje> actores = new ArrayList<>();
		List<Genero> clasificaciones = new ArrayList<>();
		
		if(metrajeDTO.getIdGenero()==null)  {
			tieneGenero = false;
			System.out.println("1er if tieneGenero: " + tieneGenero);
			
		}else if(metrajeDTO.getIdGenero()!=null){
			tieneGenero = true;
			System.out.println("2do if tieneGenero: " + tieneGenero);
		}
		if(metrajeDTO.getIdPersonajes()==null)  {
			tienePersonaje = false;
			System.out.println("1er if tienePersonaje: " + tienePersonaje);
		}else if(metrajeDTO.getIdPersonajes()!=null){
			tienePersonaje = true;
			System.out.println("2do if tienePersonaje: " + tienePersonaje);
		}
		//-----------------------------PRIMER CASO-----------------------------
		
		if(tieneGenero==true && tienePersonaje==true) {
			System.out.println("tiene genero y tiene personaje");	
			System.out.println("tengo que comprobar que los generos estan cargados en mi base");
			System.out.println("tengo que comprobar que los personajes existan");
			
			for(GeneroDTO p : metrajeDTO.getIdGenero()) {
				for(Genero generosTotales : generoRepository.findAll()) {
					Genero generoAcumulador;
					if(p.getId()==generosTotales.getId()){
						generoAcumulador = new GeneroBuilder().withGenero(generosTotales).build();
						generoAcumulador.setId(generosTotales.getId());
						
						clasificaciones.add(generoAcumulador);
						generosTotales.getMetrajesConEstaCategoria().add(metraje);
					}
					generoRepository.save(generosTotales);		
				}
			}
			metraje.setClasificado(clasificaciones);
			
			for(PersonajeDTO p : metrajeDTO.getIdPersonajes()) {
				for(Personaje personajesTotales : personajeRepository.findAll()) {
					Personaje personajeAcumulador;
					if(p.getId()==personajesTotales.getId()){
						personajeAcumulador = new PersonajeBuilder().withPersonaje(personajesTotales).build();
						personajeAcumulador.setId(personajesTotales.getId());
						
						actores.add(personajeAcumulador);
						personajesTotales.getParticipaciones().add(metraje);
					}
					personajeRepository.save(personajesTotales);		
				}
			}

			metraje.setActua(actores);
			metrajeRepository.save(metraje);
			
		//-----------------------------SEGUNDO CASO-----------------------------	
		}else if(tieneGenero==true && tienePersonaje==false) {
			System.out.println("tiene genero y no tiene personaje");
			for(GeneroDTO p : metrajeDTO.getIdGenero()) {
				for(Genero generosTotales : generoRepository.findAll()) {
					Genero generoAcumulador;
					if(p.getId()==generosTotales.getId()){
						generoAcumulador = new GeneroBuilder().withGenero(generosTotales).build();
						generoAcumulador.setId(generosTotales.getId());
						
						clasificaciones.add(generoAcumulador);
						generosTotales.getMetrajesConEstaCategoria().add(metraje);
					}
					generoRepository.save(generosTotales);		
				}
			}
			metraje.setClasificado(clasificaciones);
			metrajeRepository.save(metraje);
			
		//-----------------------------TERCER CASO-----------------------------	
		}else if(tieneGenero==false && tienePersonaje==true) {
			System.out.println("no tiene genero y tiene personaje");
			System.out.println("consideraciones: ");
			System.out.println("* tengo que chequear que todos los personajes en el metraje actual existan");
			System.out.println("* en caso de no existir tengo que decidir si lo creo o no (problablemente tenga que no hacerlo aca sino que tenga que llamar al insertar de personaje)");
			System.out.println("* si existen todos agrego el metraje y la relacion entre ambos");
			
			for(PersonajeDTO p : metrajeDTO.getIdPersonajes()) {
				for(Personaje personajesTotales : personajeRepository.findAll()) {
					Personaje personajeAcumulador;
					if(p.getId()==personajesTotales.getId()){
						personajeAcumulador = new PersonajeBuilder().withPersonaje(personajesTotales).build();
						personajeAcumulador.setId(personajesTotales.getId());
						
						actores.add(personajeAcumulador);
						personajesTotales.getParticipaciones().add(metraje);
					}
					personajeRepository.save(personajesTotales);		
				}
			}
			metraje.setActua(actores);
			metrajeRepository.save(metraje);
		//-----------------------------CUARTO CASO-----------------------------	
		}else if(tieneGenero==false && tienePersonaje==false) {
			System.out.println("no tiene genero y no tiene personaje");
			metrajeRepository.save(metraje);
		}
		System.out.println("idGenero" + metrajeDTO.getIdGenero());
		System.out.println("idPersonaje" + metrajeDTO.getIdPersonajes());
		System.out.println("tieneGenero: " + tieneGenero);
		System.out.println("tienePersonaje: " + tienePersonaje);		
		System.out.println("--------------------------------------------------------------------------------");		

		return metraje;
		}
		
	
	
	@Override
	public Metraje actualizarMetraje(Long id, MetrajeDTO metrajeDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarMetraje(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}