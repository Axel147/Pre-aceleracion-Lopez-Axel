package com.disney.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "metraje")
public class Metraje {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(name = "titulo")
	 private String titulo;
	 @Column(name = "imagen")
	 private String imagen;
	 @Column(name = "fecha")
	 private Date fecha; //revisar importacion
	 @Column(name = "calificacion")
	 private double calificacion;

	 @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.MERGE})
	 @JoinTable(
			 name="metraje_personaje" ,
			 joinColumns=@JoinColumn(name = "metraje_id"),
			 inverseJoinColumns=@JoinColumn(name = "personaje_id"))
	 private List<Personaje> actua = new ArrayList<>();
	 
	 @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.MERGE})
	 @JoinTable(
			 name="metraje_genero" ,
			 joinColumns=@JoinColumn(name = "id_genero"),
			 inverseJoinColumns=@JoinColumn(name = "id_metraje"))
	 private List<Genero> clasificado = new ArrayList<>();
	
	public Metraje() {
		super();
	}

	public Metraje(String titulo, String imagen, Date fecha, double calificacion/*,ArrayList<Personaje> idPersonajes*/) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fecha;
		this.calificacion = calificacion;
		//this.idPersonajes = idPersonajes;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public List<Personaje> getActua() {
		return actua;
	}
	public void setActua(List<Personaje> actua) {
		this.actua = actua;
	}

	public List<Genero> getClasificado() {
		return clasificado;
	}

	public void setClasificado(List<Genero> clasificado) {
		this.clasificado = clasificado;
	}
}