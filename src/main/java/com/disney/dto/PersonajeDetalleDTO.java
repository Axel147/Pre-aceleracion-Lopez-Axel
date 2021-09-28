package com.disney.dto;

import java.util.List;

public class PersonajeDetalleDTO {
	private Long id;
	private String nombre;
	private String imagen;
	private int edad;
	private double peso;
	private String historia;
	private List<MetrajeSinPersonajeDTO> idMetraje;
	
	
	public PersonajeDetalleDTO() {
		super();
	}
	
	public PersonajeDetalleDTO(Long id,String nombre, String imagen, int edad, double peso, String historia) {
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}
	
	public PersonajeDetalleDTO(String nombre, String imagen, int edad, double peso, String historia) {
		
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public List<MetrajeSinPersonajeDTO> getIdMetraje() {
		return idMetraje;
	}

	public void setIdMetraje(List<MetrajeSinPersonajeDTO> idMetraje) {
		this.idMetraje = idMetraje;
	}
	
}
