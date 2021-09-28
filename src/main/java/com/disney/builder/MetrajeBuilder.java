package com.disney.builder;

import java.sql.Date;
import java.util.List;

import com.disney.dto.MetrajeDTO;
import com.disney.dto.MetrajeDetalleDTO;
import com.disney.dto.MetrajeImaTitFecDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.model.Metraje;
import com.disney.model.Personaje;

public class MetrajeBuilder {
	private String titulo;
	private String imagen;
	private Date fecha;
	private double calificacion;
	
	public MetrajeBuilder withMetrajeDTO(MetrajeDTO metrajeDTO) {
		this.titulo = metrajeDTO.getTitulo();
		this.imagen = metrajeDTO.getImagen();
		this.fecha = metrajeDTO.getFecha();
		this.calificacion = metrajeDTO.getCalificacion();
		
		return this;
	}
	
	public Metraje build() {
		return new Metraje(this.titulo, this.imagen, this.fecha, this.calificacion);
	}
	
	
	public MetrajeBuilder withMetraje(Metraje metraje) {
		this.titulo = metraje.getTitulo();
		this.imagen = metraje.getImagen();
		this.fecha = metraje.getFecha();
		this.calificacion = metraje.getCalificacion();
		
		return this;
	}
	
	public MetrajeDTO buildMetrajeDTO() {
		return new MetrajeDTO(this.titulo, this.imagen, this.fecha, this.calificacion);
	}

	
	public MetrajeDetalleDTO buildMetrajeDetalleDTO() {
		return new MetrajeDetalleDTO(this.titulo, this.imagen, this.fecha, this.calificacion);
	}

	public MetrajeBuilder imaTitFecWithMetraje(Metraje metraje) {
		this.titulo = metraje.getTitulo();
		this.imagen = metraje.getImagen();
		this.fecha = metraje.getFecha();
		
		return this;
	}
	
	public MetrajeImaTitFecDTO buildImaTitFecMetrajeImaTitFecDTO() {
		return new MetrajeImaTitFecDTO(this.titulo, this.imagen, this.fecha);
	}
	
	
}
