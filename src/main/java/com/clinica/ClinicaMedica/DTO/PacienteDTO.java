package com.clinica.ClinicaMedica.DTO;

import javax.validation.constraints.NotNull;

public class PacienteDTO extends UsuarioDTO{
	
	@NotNull
	private boolean obraSocial;

	public boolean isObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(boolean obraSocial) {
		this.obraSocial = obraSocial;
	}
	
}
