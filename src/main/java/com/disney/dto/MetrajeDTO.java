package com.disney.dto;

import java.sql.Date;
import java.util.List;

import com.disney.model.Personaje;

public class MetrajeDTO {
	//private Long id;
	private String titulo;
	private String imagen;
	private Date fecha;
	private double calificacion;
	//private List<Long> idPersonajes;
	private List<PersonajeDTO> idPersonajes;
	private List<GeneroDTO> idGenero;
	//private List<GeneroDTO> idGenero;
	
	public MetrajeDTO(){
		
	}
	
	public MetrajeDTO(Long id, String titulo, String imagen, Date fecha, double calificacion) {
		//this.id = id;
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fecha;
		this.calificacion = calificacion;
	}
	
	public MetrajeDTO(String titulo, String imagen, Date fecha, double calificacion) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fecha;
		this.calificacion = calificacion;
	}
	
	public MetrajeDTO(String titulo, String imagen, Date fecha, double calificacion,List<PersonajeDTO> idPersonajes,List<GeneroDTO> idGenero) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.idPersonajes = idPersonajes;
		this.idGenero = idGenero;
	}
/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
*/
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public List<PersonajeDTO> getIdPersonajes() {
		return idPersonajes;
	}

	public void setIdPersonajes(List<PersonajeDTO> idPersonajes) {
		this.idPersonajes = idPersonajes;
	}

	public List<GeneroDTO> getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(List<GeneroDTO> idGenero) {
		this.idGenero = idGenero;
	}
	
}
