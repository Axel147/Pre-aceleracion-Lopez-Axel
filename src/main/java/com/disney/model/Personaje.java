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
@Table(name = "personaje")
public class Personaje {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "nombre")
		private String nombre;
		@Column(name = "imagen")
		private String imagen;
		@Column(name = "edad")
		private int edad;
		@Column(name = "peso")
		private double peso;
		@Column(name = "historia")
		private String historia;

		@ManyToMany(mappedBy = "actua")
		private List<Metraje> participaciones = new ArrayList<>();
		
		
		public Personaje() {
			super();
		}

		public Personaje(String nombre, String imagen, int edad, double peso, String historia) {
			
			this.nombre = nombre;
			this.imagen = imagen;
			this.edad = edad;
			this.peso = peso;
			this.historia = historia;
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


		public List<Metraje> getParticipaciones() {
			return participaciones;
		}

		public void setParticipaciones(List<Metraje> participaciones) {
			this.participaciones = participaciones;
		}

 
}