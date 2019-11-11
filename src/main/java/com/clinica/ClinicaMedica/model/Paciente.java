package com.clinica.ClinicaMedica.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Paciente")
@Table(name = "paciente")
//@AttributeOverride(name = "id", column = @Column(name = "id_paciente"))
public class Paciente extends Usuario{
	
	private boolean obraSocial;

	public boolean isObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(boolean obraSocial) {
		this.obraSocial = obraSocial;
	}
	
}
