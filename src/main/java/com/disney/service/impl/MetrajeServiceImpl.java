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
import com.disney.dto.MetrajeDetalleDTO;
import com.disney.dto.MetrajeImaTitFecDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.dto.PersonajeSinMetrajeDTO;
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
	public MetrajeDetalleDTO obtenerMetraje(Long id) {
		Metraje metraje = metrajeRepository.getById(id);
		MetrajeDetalleDTO metrajeDetallado = new MetrajeBuilder().withMetraje(metraje).buildMetrajeDetalleDTO();
		metrajeDetallado.setId(metraje.getId());
		List<PersonajeSinMetrajeDTO> listaElenco= new ArrayList<>();
		
		for(Personaje actua : metraje.getActua()) {
			for(Personaje actoresTotalesRegistrados : personajeRepository.findAll()) {
				PersonajeSinMetrajeDTO personajeSinMetrajeDTO = new PersonajeSinMetrajeDTO();
				if( actua.getId() == actoresTotalesRegistrados.getId()) {
					personajeSinMetrajeDTO = new PersonajeBuilder().withPersonaje(actoresTotalesRegistrados).buildPersonajeSinMetrajeDTO();
					personajeSinMetrajeDTO.setId(actoresTotalesRegistrados.getId());
					
					listaElenco.add(personajeSinMetrajeDTO);
				}
			}
		}
		
		metrajeDetallado.setIdPersonajes(listaElenco);
		
		return metrajeDetallado;
	}
	@Override
	public List<MetrajeImaTitFecDTO> obtenerMetrajes() {
		List<MetrajeImaTitFecDTO> listaFinal = new ArrayList<>();
		for(Metraje metrajesRegistrados : metrajeRepository.findAll()) {
			MetrajeImaTitFecDTO metrajeImaTitFecDTO = new MetrajeBuilder().imaTitFecWithMetraje(metrajesRegistrados).buildImaTitFecMetrajeImaTitFecDTO();
			
			listaFinal.add(metrajeImaTitFecDTO);
		}	
		return listaFinal;
	}
	
	
	@Override
	public Metraje insertarMetraje(MetrajeDTO metrajeDTO) {
		Metraje metraje = new MetrajeBuilder().withMetrajeDTO(metrajeDTO).build();
		boolean tieneGenero = false;
		boolean tienePersonaje = false;
		
		if(metrajeDTO.getIdGenero()==null)  {
			tieneGenero = false;
			
		}else if(metrajeDTO.getIdGenero()!=null){
			tieneGenero = true;
			
		}if(metrajeDTO.getIdPersonajes()==null)  {
			tienePersonaje = false;
			
		}else if(metrajeDTO.getIdPersonajes()!=null){
			tienePersonaje = true;
		}
		//-----------------------------PRIMER CASO-----------------------------
		if(tieneGenero==true && tienePersonaje==true) {
			metraje = almacenarGenero(metrajeDTO);
			Metraje metrajeConPersonajes = almacenarPersonaje(metrajeDTO);
			metraje.setActua(metrajeConPersonajes.getActua());
			metrajeRepository.save(metraje);
			
		//-----------------------------SEGUNDO CASO-----------------------------	
		}else if(tieneGenero==true && tienePersonaje==false) {
			metraje = almacenarGenero(metrajeDTO);
			metrajeRepository.save(metraje);
			
		//-----------------------------TERCER CASO-----------------------------	
		}else if(tieneGenero==false && tienePersonaje==true) {
			metraje = almacenarPersonaje(metrajeDTO);
			metrajeRepository.save(metraje);
			
		//-----------------------------CUARTO CASO-----------------------------	
		}else if(tieneGenero==false && tienePersonaje==false) {
			metrajeRepository.save(metraje);
		}
		return metraje;	
	}
	
	private Metraje almacenarPersonaje(MetrajeDTO metrajeDTO) {
		Metraje metraje = new MetrajeBuilder().withMetrajeDTO(metrajeDTO).build();
		List<Personaje> actores = new ArrayList<>();
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
		return metraje;
	}
	
	private Metraje almacenarGenero(MetrajeDTO metrajeDTO) {
		Metraje metraje = new MetrajeBuilder().withMetrajeDTO(metrajeDTO).build();
		List<Genero> clasificaciones = new ArrayList<>();
		
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
		return metraje;
	}
	
	
	@Override
	public Metraje actualizarMetraje(Long id, MetrajeDTO metrajeDTO) {
		/*Metraje metrajeModif = metrajeRepository.getById(id);
		Metraje metrajeAcum = new Metraje();
		metrajeModif = new MetrajeBuilder().withMetrajeDTO(metrajeDTO).build();
		
		metrajeAcum = almacenarPersonaje(metrajeDTO);
		metrajeModif.setActua(metrajeAcum.getActua());
		metrajeAcum = almacenarGenero(metrajeDTO);
		metrajeModif.setClasificado(metrajeAcum.getClasificado());
		
		metrajeRepository.save(metrajeModif);
		*/
		return null;
	}
	
	
	@Override
	public void eliminarMetraje(Long id) {
		metrajeRepository.deleteById(id);
		
	}
	
	
	
}