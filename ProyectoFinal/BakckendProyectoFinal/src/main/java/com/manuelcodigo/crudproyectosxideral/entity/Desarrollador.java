package com.manuelcodigo.crudproyectosxideral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
	 
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    
	@Entity
	@Table(name="desarrollador")
	public class Desarrollador {

		// define fields
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="nombre")
		private String nombre;
		
		@Column(name="apellido")
		private String apellido;
		
		@Column(name="email")
		private String email;
		
		@Column(name="proyecto")
		private String proyecto;
		
		@Column(name="puesto")
		private String puesto;
		
		

		
	}
