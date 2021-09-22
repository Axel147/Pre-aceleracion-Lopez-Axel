package com.disney.dto;

import java.sql.Date;

public class MetrajeImaTitFecDTO {
	private String titulo;
	private String imagen;
	private Date fecha;
	
	
	public MetrajeImaTitFecDTO(String titulo, String imagen, Date fecha) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fecha;
	}


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
	
	
}
