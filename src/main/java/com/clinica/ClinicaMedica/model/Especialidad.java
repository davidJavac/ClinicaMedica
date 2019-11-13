package com.clinica.ClinicaMedica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity(name = "Especialidad")
@Table(name = "especialidad")
@DynamicUpdate(true)
public class Especialidad{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_especialidad;
	private String nombre;
	private int cantidad_turnos;
	
	public int getCantidad_turnos() {
		return cantidad_turnos;
	}
	
	public void setCantidad_turnos(int cantidad_turnos) {
		this.cantidad_turnos = cantidad_turnos;
	}
	

	public String getNombre() {
		return nombre;
	}

	public Long getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Long id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
