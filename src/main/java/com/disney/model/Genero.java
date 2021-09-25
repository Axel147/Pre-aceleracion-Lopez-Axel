package com.disney.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genero")
public class Genero {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 @Column(name = "nombre")
	 private String nombre;
	 @Column(name = "imagen")
	 private String imagen;
	 
	 @ManyToMany(mappedBy = "clasificado")
		private List<Metraje> metrajesConEstaCategoria = new ArrayList<>();
	 
	 
	 public Genero() {
	  
	 }
	 
	 public Genero(Long id, String nombre, String imagen) {
		 this.id = id;
		 this.nombre = nombre;
		 this.imagen = imagen;
	 }
	 
	 public Genero(String nombre, String imagen) {
		 this.nombre = nombre;
		 this.imagen = imagen;
	 }
	
	 public long getId() {
	  return id;
	 }
	
	 public void setId(long id) {
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

	public List<Metraje> getMetrajesConEstaCategoria() {
		return metrajesConEstaCategoria;
	}

	public void setMetrajesConEstaCategoria(List<Metraje> metrajesConEstaCategoria) {
		this.metrajesConEstaCategoria = metrajesConEstaCategoria;
	}
	 
 
}