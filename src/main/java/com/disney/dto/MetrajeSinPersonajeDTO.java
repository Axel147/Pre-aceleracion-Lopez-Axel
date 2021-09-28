package com.disney.dto;

import java.sql.Date;

public class MetrajeSinPersonajeDTO {
		private Long id;
		private String titulo;
		private String imagen;
		private Date fecha;
		private double calificacion;
		
		public MetrajeSinPersonajeDTO(){
			
		}
		
		public MetrajeSinPersonajeDTO(Long id, String titulo, String imagen, Date fecha, double calificacion) {
			//this.id = id;
			this.titulo = titulo;
			this.imagen = imagen;
			this.fecha = fecha;
			this.calificacion = calificacion;
		}
		
		public MetrajeSinPersonajeDTO(String titulo, String imagen, Date fecha, double calificacion) {
			this.titulo = titulo;
			this.imagen = imagen;
			this.fecha = fecha;
			this.calificacion = calificacion;
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
		
}
