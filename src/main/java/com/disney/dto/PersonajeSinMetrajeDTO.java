package com.disney.dto;

public class PersonajeSinMetrajeDTO {
	private Long id;
	private String nombre;
	private String imagen;
	private int edad;
	private double peso;
	private String historia;
	
	
	public PersonajeSinMetrajeDTO() {
		super();
	}
	
	public PersonajeSinMetrajeDTO(Long id,String nombre, String imagen, int edad, double peso, String historia) {
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}
	
	public PersonajeSinMetrajeDTO(String nombre, String imagen, int edad, double peso, String historia) {
		
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

}
