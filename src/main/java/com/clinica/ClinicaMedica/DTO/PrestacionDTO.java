package com.clinica.ClinicaMedica.DTO;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class PrestacionDTO implements Serializable{

	private Long id;
	@Size(max = 20, min = 1, message = "El campo tipo solo debe contener una cantidad de caracteres en el rango de 1-20")
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private String especialidad;
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
		
}
