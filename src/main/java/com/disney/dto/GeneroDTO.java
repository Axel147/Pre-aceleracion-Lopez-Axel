package com.disney.dto;

public class GeneroDTO {
	private Long id;
	private String nombre;
	private String imagen;
	
	public GeneroDTO() {
		
	}
	
	public GeneroDTO(String nombre, String imagen) {
		this.nombre = nombre;
		this.imagen = imagen;
	}
	
	public GeneroDTO(Long id, String nombre, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
