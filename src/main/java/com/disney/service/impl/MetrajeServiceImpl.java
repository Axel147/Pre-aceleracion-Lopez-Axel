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

import com.disney.builder.MetrajeBuilder;
import com.disney.builder.PersonajeBuilder;
import com.disney.dto.MetrajeDTO;
import com.disney.dto.MetrajeImaTitFecDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.model.Metraje;
import com.disney.model.Personaje;
import com.disney.repository.MetrajeRepository;
import com.disney.repository.PersonajeRepository;
import com.disney.service.IMetrajeService;

@Service
public class MetrajeServiceImpl implements IMetrajeService{
	@Autowired
	private MetrajeRepository metrajeRepository;
	@Autowired
	private PersonajeRepository personajeRepository;
	
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
		// TODO Auto-generated method stub
		return null;
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
	
	
	
	
	
	/* ----------------------------------------------------------------------------------------------------FUNCIONANDO--------------------------------------------------------------------------------------------------------------------------------
	@Override
	public MetrajeDTO obtenerMetraje(Long id) {
		Metraje metraje = metrajeRepository.getOne(id);
		MetrajeDTO metrajeDTO = new MetrajeBuilder().withMetraje(metraje).buildMetrajeDTO();
		metrajeDTO.setId(metraje.getId());
		List<PersonajeDTO> listaElenco= new ArrayList<>();
		
		for(Personaje actua : metraje.getActua()) {
			for(Personaje actoresTotalesRegistrados : personajeRepository.findAll()) {
				PersonajeDTO personajeDTO = new PersonajeDTO();
				if( actua.getId() == actoresTotalesRegistrados.getId()) {
					personajeDTO = new PersonajeBuilder().withPersonaje(actoresTotalesRegistrados).buildPersonajeDTO();
					personajeDTO.setId(actoresTotalesRegistrados.getId());
					
					listaElenco.add(personajeDTO);
				}
			}
		}
		
		metrajeDTO.setIdPersonajes(listaElenco);
		return metrajeDTO;
	}
	
	@Override
	public List<MetrajeDTO> obtenerMetrajes() {
		List<MetrajeDTO> listaFinal= new ArrayList<>();
		
		for(Metraje metrajesRegistrados : metrajeRepository.findAll()) {
			MetrajeDTO metrajeDTO;
			List<PersonajeDTO> listaElenco= new ArrayList<>();
			metrajeDTO = new MetrajeBuilder().withMetraje(metrajesRegistrados).buildMetrajeDTO();
			metrajeDTO.setId(metrajesRegistrados.getId());
			for(Personaje actua : metrajesRegistrados.getActua()) {
				PersonajeDTO personajeDTO = new PersonajeBuilder().withPersonaje(actua).buildPersonajeDTO();
				personajeDTO.setId(actua.getId());
				
				
				listaElenco.add(personajeDTO);
			}
			metrajeDTO.setIdPersonajes(listaElenco);
			listaFinal.add(metrajeDTO);
		}
		return listaFinal;
	}
	
	@Override
	public Metraje insertarMetraje(MetrajeDTO metrajeDTO) {
		List<Personaje> actores = new ArrayList<>();
		Metraje metraje = new MetrajeBuilder().withMetrajeDTO(metrajeDTO).build();
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
		return metraje;
	}

	@Override
	public Metraje actualizarMetraje(Long id,MetrajeDTO metrajeDTO) {
		Metraje metraje = metrajeRepository.getById(id);
		if(metrajeDTO.getTitulo() != null){
			metraje.setTitulo(metrajeDTO.getTitulo());
		}if(metrajeDTO.getImagen() != null){
			metraje.setImagen(metrajeDTO.getImagen());
		}if(metrajeDTO.getFecha() != null){
			metraje.setFecha(metrajeDTO.getFecha());
		}if(metrajeDTO.getCalificacion() != 0){
			metraje.setCalificacion(metrajeDTO.getCalificacion());
		}if(!(compararPersonajes(metraje.getActua(), metrajeDTO.getIdPersonajes()))){
			Metraje
		
		return metrajeRepository.save(metraje);
	}

	@Override
	public void eliminarMetraje(Long id) {
		metrajeRepository.deleteById(id);
	}

*/
}