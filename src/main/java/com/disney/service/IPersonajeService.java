package com.disney.service;

import java.util.List;

import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.model.Personaje;

public interface IPersonajeService {
	
	public PersonajeImaNomDTO obtenerPersonaje(Long id);
	
	public List<PersonajeImaNomDTO>obtenerPersonajes();
	
	public Personaje insertarPersonaje(PersonajeDTO personajeDTO);
	
	public Personaje actualizarPersonaje(Long id,PersonajeDTO personajeDTO);
	
	public void eliminarPersonaje(Long id);
	
}
