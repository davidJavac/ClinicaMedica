package com.clinica.ClinicaMedica.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;


public class MedicoDTO extends UsuarioDTO implements Serializable{
	
	@Size(max = 30, min = 1, message = "El campo especialidad solo debe contener una cantidad de caracteres en el rango de 1-30")
	private String especialidad;
	@Size(max = 10, min = 1, message = "El campo matrícula solo debe contener una cantidad de caracteres en el rango de 1-10")
	private String matricula;
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
