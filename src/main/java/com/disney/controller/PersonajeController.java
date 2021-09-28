package com.disney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeDetalleDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.model.Personaje;
import com.disney.service.IPersonajeService;

@RestController
@RequestMapping("/characters")
@CrossOrigin("*")
public class PersonajeController {
	@Autowired
	private IPersonajeService iPersonajeService;
	
	@GetMapping("/{id}")
	public PersonajeDetalleDTO obtenerPersonaje(@PathVariable("id") Long id) {
		return iPersonajeService.obtenerPersonaje(id);
	}
	
	@GetMapping
	public  ResponseEntity<?> obtenerPersonajes(){
		 return new  ResponseEntity<>(iPersonajeService.obtenerPersonajes(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> insertarPersonaje(@RequestBody PersonajeDTO personajeDTO) {
		Personaje personaje = iPersonajeService.insertarPersonaje(personajeDTO);
		return new ResponseEntity<>(personaje, HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<?> actualizarPersonaje(@PathVariable("id") Long id, @RequestBody PersonajeDTO personajeDTO) {
		Personaje personaje = iPersonajeService.actualizarPersonaje(id, personajeDTO);
		return new ResponseEntity<>(personaje, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPersonaje(@PathVariable("id") Long id) {
		iPersonajeService.eliminarPersonaje(id);
		return new ResponseEntity<>("Metraje eliminado correctamente", HttpStatus.OK);
	}

}
