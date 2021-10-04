package com.disney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.builder.GeneroBuilder;
import com.disney.builder.MetrajeBuilder;
import com.disney.builder.PersonajeBuilder;
import com.disney.dto.GeneroDTO;
import com.disney.dto.MetrajeDTO;
import com.disney.dto.MetrajeSinPersonajeDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeDetalleDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.model.Genero;
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
	public PersonajeDetalleDTO obtenerPersonaje(Long id) {
		Personaje personaje = personajeRepository.getById(id);
		PersonajeDetalleDTO personajeDetallado = new PersonajeBuilder().withPersonaje(personaje).buildPersonajeDetalleDTO();
		List<MetrajeSinPersonajeDTO> carreraCinematografica = new ArrayList<>();
		personajeDetallado.setId(personaje.getId());
		for(Metraje actuo : personaje.getParticipaciones()) {
			for(Metraje metrajesRegistrados : metrajeRepository.findAll()) {
				MetrajeSinPersonajeDTO metrajeDTO;
				if(actuo.getId() == metrajesRegistrados.getId()) {
					metrajeDTO = new MetrajeBuilder().withMetraje(metrajesRegistrados).buildMetrajeSinPersonajeDTO();
					metrajeDTO.setId(metrajesRegistrados.getId());
					carreraCinematografica.add(metrajeDTO);
				}
			}
		}
		personajeDetallado.setIdMetraje(carreraCinematografica);
	
		return personajeDetallado;
	}

	@Override
	public List<PersonajeImaNomDTO> obtenerPersonajes() {
		List<PersonajeImaNomDTO> listaFinal = new ArrayList<>();
		for(Personaje personajesRegistrados : personajeRepository.findAll()) {
			PersonajeImaNomDTO personajeImaNomDTO = new PersonajeBuilder().imagenNombreWithPersonaje(personajesRegistrados).buildImagenNombrePersonaje();
			
			listaFinal.add(personajeImaNomDTO);
		}
		
		return listaFinal;
	}

	@Override
	public Personaje insertarPersonaje(PersonajeDTO personajeDTO) {
		Personaje personaje = new PersonajeBuilder().withPersonajeDTO(personajeDTO).build();
		boolean tieneMetraje = true;
		List<Metraje> participaciones =  new ArrayList<>();
		
		if(personajeDTO.getIdMetraje() == null) {
			tieneMetraje = false;
		}//----------------------PRIMER CASO----------------------
		if(tieneMetraje == true) {
			System.out.println("Tiene peliculas asociadas");
			personaje = almacenarMetraje(personajeDTO);
			personajeRepository.save(personaje);
		}//----------------------SEGUNDO CASO----------------------
		else {
			System.out.println("Sin peliculas");
			personaje.setParticipaciones(participaciones);
			personajeRepository.save(personaje);
		}
		return personaje;
	}
	
	
	private Personaje almacenarMetraje(PersonajeDTO personajeDTO) {
		Personaje personaje = new PersonajeBuilder().withPersonajeDTO(personajeDTO).build();
		List<Metraje> actuo = new ArrayList<>();
		for(MetrajeDTO m : personajeDTO.getIdMetraje()) {
			for(Metraje metrajesTotales : metrajeRepository.findAll()) {
				Metraje metrajeAcumulador;
				if(m.getId()==metrajesTotales.getId()){
					metrajeAcumulador = new MetrajeBuilder().withMetraje(metrajesTotales).build();
					metrajeAcumulador.setId(metrajesTotales.getId());
					
					actuo.add(metrajeAcumulador);
					metrajesTotales.getActua().add(personaje);
				}
			}
		}
		personaje.setParticipaciones(actuo);
		return personaje;
	}

	@Override
	public Personaje actualizarPersonaje(Long id, PersonajeDTO personajeDTO) {
		
		return null;
	}

	@Override
	public void eliminarPersonaje(Long id) {
		personajeRepository.deleteById(id);
		
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