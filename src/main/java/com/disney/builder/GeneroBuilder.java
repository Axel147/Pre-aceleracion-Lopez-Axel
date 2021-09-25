package com.disney.builder;

import java.sql.Date;

import com.disney.dto.GeneroDTO;
import com.disney.dto.MetrajeDTO;
import com.disney.model.Genero;
import com.disney.model.Metraje;

public class GeneroBuilder {
	private String nombre;
	private String imagen;
	
	public GeneroBuilder withGeneroDTO(GeneroDTO generoDTO) {
		this.nombre = generoDTO.getNombre();
		this.imagen = generoDTO.getImagen();
		
		return this;
	}
	
	public Genero build() {
		return new Genero(this.nombre, this.imagen);
	}
	
	public GeneroBuilder withGenero(Genero genero) {
		this.nombre = genero.getNombre();
		this.imagen = genero.getImagen();
		
		return this;
	}
	
}
