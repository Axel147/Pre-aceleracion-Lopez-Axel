package com.disney.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	 //@Column(name = "metraje")
	 //private List<Metraje> clasificacion;
	 
	 public Genero() {
	  
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
	 
 
 
}