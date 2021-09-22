package com.disney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.builder.MetrajeBuilder;
import com.disney.builder.PersonajeBuilder;
import com.disney.dto.MetrajeDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.model.Metraje;
import com.disney.model.Personaje;
import com.disney.repository.MetrajeRepository;
import com.disney.repository.PersonajeRepository;
import com.disney.service.IPersonajeService;

@Service
public class PersonajeServiceImpl implements IPersonajeService{
	@Autowired
	private PersonajeRepository personajeRepository;
	@Autowired
	private MetrajeRepository metrajeRepository;
	

	@Override
	public PersonajeDTO obtenerPersonaje(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonajeDTO> obtenerPersonajes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personaje insertarPersonaje(PersonajeDTO personajeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personaje actualizarPersonaje(Long id, PersonajeDTO personajeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPersonaje(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
/* ----------------------------------------------------------------------------------------------------FUNCIONANDO--------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public PersonajeDTO obtenerPersonaje(Long id) {
		Personaje personaje = personajeRepository.getById(id);
		PersonajeDTO personajeDTO = new PersonajeBuilder().withPersonaje(personaje).buildPersonajeDTO();
		List<MetrajeDTO> carreraCinematografica = new ArrayList<>();
		personajeDTO.setId(personaje.getId());
		for(Metraje actuo : personaje.getParticipaciones()) {
			for(Metraje metrajesRegistrados : metrajeRepository.findAll()) {
				MetrajeDTO metrajeDTO;
				if(actuo.getId() == metrajesRegistrados.getId()) {
					metrajeDTO = new MetrajeBuilder().withMetraje(metrajesRegistrados).buildMetrajeDTO();
					metrajeDTO.setId(metrajesRegistrados.getId());
					carreraCinematografica.add(metrajeDTO);
				}
			}
		}
		personajeDTO.setIdMetraje(carreraCinematografica);
		return personajeDTO;
	}

	@Override
	public List<PersonajeDTO> obtenerPersonajes() {
		List<PersonajeDTO> listaFinal = new ArrayList<>();
		
		for(Personaje personajesRegistrados : personajeRepository.findAll()) {
			PersonajeDTO personajeDTO = new PersonajeDTO();
			
			List<MetrajeDTO> listaMetrajes = new ArrayList<>();
			personajeDTO = new PersonajeBuilder().withPersonaje(personajesRegistrados).buildPersonajeDTO();
			personajeDTO.setId(personajesRegistrados.getId());
			for(Metraje actuo : personajesRegistrados.getParticipaciones()) {
				MetrajeDTO metrajeDTO = new MetrajeBuilder().withMetraje(actuo).buildMetrajeDTO();
				metrajeDTO.setId(actuo.getId());
				listaMetrajes.add(metrajeDTO);
			}
			personajeDTO.setIdMetraje(listaMetrajes);
			listaFinal.add(personajeDTO);
		}
		
		return listaFinal;
	}

	@Override
	public Personaje insertarPersonaje(PersonajeDTO personajeDTO) {
		
		List<Metraje> peliculas = new ArrayList<>();
		Personaje personaje = new PersonajeBuilder().withPersonajeDTO(personajeDTO).build();
		for(MetrajeDTO m : personajeDTO.getIdMetraje()) {
			for(Metraje metrajesTotales : metrajeRepository.findAll()) {
				Metraje metrajeAcumulador;
				if(m.getId()==metrajesTotales.getId()){
					metrajeAcumulador = new MetrajeBuilder().withMetraje(metrajesTotales).build();
					metrajeAcumulador.setId(metrajesTotales.getId());
	
					peliculas.add(metrajeAcumulador);
					metrajesTotales.getActua().add(personaje);
				}
				metrajeRepository.save(metrajesTotales);		
			}
		}
		personaje.setParticipaciones(peliculas);
		personajeRepository.save(personaje);
		return personaje;
		

	}

	@Override
	public Personaje actualizarPersonaje(Long id, PersonajeDTO personajeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPersonaje(Long id) {
		personajeRepository.deleteById(id);
	}


*/
	
}