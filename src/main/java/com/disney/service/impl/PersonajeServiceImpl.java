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
		Personaje personajeModif = personajeRepository.getById(id);
		Personaje personajeAcum;
		personajeModif = new PersonajeBuilder().withPersonajeDTO(personajeDTO).build();
		/*
		personajeModif.setNombre(personajeDTO.getNombre());
		personajeModif.setImagen(personajeDTO.getImagen());
		personajeModif.setEdad(personajeDTO.getEdad());
		personajeModif.setPeso(personajeDTO.getPeso());
		personajeModif.setHistoria(personajeDTO.getHistoria());
		*/
		personajeAcum = almacenarMetraje(personajeDTO);
		personajeModif.setParticipaciones(personajeAcum.getParticipaciones());
		
		personajeRepository.save(personajeModif);
		return null;
	}

	@Override
	public void eliminarPersonaje(Long id) {
		personajeRepository.deleteById(id);
		
	}
	
}