package com.clinica.ClinicaMedica.DTO;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
