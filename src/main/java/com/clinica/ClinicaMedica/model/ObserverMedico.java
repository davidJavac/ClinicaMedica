package com.clinica.ClinicaMedica.model;

import com.clinica.ClinicaMedica.service.UsuarioObserver;

public class ObserverMedico implements UsuarioObserver{

	private ResponseTransfer responseTransfer;
	private Medico medico;
	
	public ObserverMedico(Medico medico) {
		
		this.medico = medico;
	}
	
	public ResponseTransfer getResponseTransfer() {
		return responseTransfer;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setResponseTransfer(ResponseTransfer responseTransfer) {
		this.responseTransfer = responseTransfer;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public void update(ResponseTransfer responseTransfer) {
		// TODO Auto-generated method stub
		this.responseTransfer = responseTransfer;
	}

}
