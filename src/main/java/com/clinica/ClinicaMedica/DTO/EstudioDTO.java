package com.clinica.ClinicaMedica.DTO;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class EstudioDTO extends PrestacionDTO implements Serializable{

	@Size(max = 50, min = 1, message = "El campo nombre solo debe contener una cantidad de caracteres en el rango de 1-50")
	private String nombre;
	@Size(max = 50, min = 1, message = "El campo prediagnostico solo debe contener una cantidad de caracteres en el rango de 1-50")
	private String prediagnostico;
	public String getNombre() {
		return nombre;
	}
	public String getPrediagnostico() {
		return prediagnostico;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrediagnostico(String prediagnostico) {
		this.prediagnostico = prediagnostico;
	}
	
}
