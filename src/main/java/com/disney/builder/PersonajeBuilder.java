package com.disney.builder;

import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeImaNomDTO;
import com.disney.dto.PersonajeSinMetrajeDTO;
import com.disney.model.Personaje;

public class PersonajeBuilder {
	private String nombre;
	private String imagen;
	private int edad;
	private double peso;
	private String historia;
	
	public PersonajeBuilder imagenNombreWithPersonaje(Personaje personaje) {
		this.nombre = personaje.getNombre();
		this.imagen = personaje.getImagen();	
		return this;
	}
	
	public PersonajeBuilder withPersonajeDTO(PersonajeDTO personajeDTO) {
		this.nombre = personajeDTO.getNombre();
		this.imagen = personajeDTO.getImagen();
		this.edad = personajeDTO.getEdad();
		this.peso = personajeDTO.getPeso();
		this.historia = personajeDTO.getHistoria();
		
		return this;
	}
	
	public Personaje build() {
		return new Personaje(this.nombre, this.imagen, this.edad, this.peso, this.historia);
	}
	
	public PersonajeImaNomDTO buildImagenNombrePersonaje() {
		return new PersonajeImaNomDTO(this.nombre, this.imagen);
	}
	
	public PersonajeBuilder withPersonaje(Personaje personaje) {
		this.nombre = personaje.getNombre();
		this.imagen = personaje.getImagen();
		this.edad = personaje.getEdad();
		this.peso = personaje.getPeso();
		this.historia = personaje.getHistoria();
		
		return this;
	}
	
	public PersonajeSinMetrajeDTO buildPersonajeSinMetrajeDTO() {
		return new PersonajeSinMetrajeDTO(this.nombre, this.imagen, this.edad, this.peso, this.historia);
	}
	
	
	public PersonajeDTO buildPersonajeDTO() {
		return new PersonajeDTO(this.nombre, this.imagen, this.edad, this.peso, this.historia);
	}
	
}
