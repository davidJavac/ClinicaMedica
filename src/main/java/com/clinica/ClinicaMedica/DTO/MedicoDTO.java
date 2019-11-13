package com.clinica.ClinicaMedica.DTO;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.clinica.ClinicaMedica.model.Especialidad;


public class MedicoDTO extends UsuarioDTO implements Serializable{
	
	private EspecialidadDTO especialidad;
	@Size(max = 10, min = 1, message = "El campo matrícula solo debe contener una cantidad de caracteres en el rango de 1-10")
	private String matricula;
	
	
	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
