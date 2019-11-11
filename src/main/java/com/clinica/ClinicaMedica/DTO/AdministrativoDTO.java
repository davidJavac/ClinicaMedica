package com.clinica.ClinicaMedica.DTO;

import javax.validation.constraints.Size;

public class AdministrativoDTO extends UsuarioDTO{

	@Size(max = 30, min = 1, message = "El campo sector solo debe contener una cantidad de caracteres en el rango de 1-30")
	private String sector;
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
}
