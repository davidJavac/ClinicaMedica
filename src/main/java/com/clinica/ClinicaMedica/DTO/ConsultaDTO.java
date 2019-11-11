package com.clinica.ClinicaMedica.DTO;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class ConsultaDTO extends PrestacionDTO implements Serializable{

	@Size(max = 50, min = 1, message = "El campo motivo solo debe contener una cantidad de caracteres en el rango de 1-50")
	private String motivo;

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
		
}
