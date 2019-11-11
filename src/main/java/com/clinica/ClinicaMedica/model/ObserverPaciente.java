package com.clinica.ClinicaMedica.model;

import com.clinica.ClinicaMedica.service.UsuarioObserver;

public class ObserverPaciente implements UsuarioObserver{

	private ResponseTransfer responseTransfer;
	private Paciente paciente;
	
	public ObserverPaciente(Paciente paciente) {
		
		this.paciente = paciente;
	}
	
	public ResponseTransfer getResponseTransfer() {
		return responseTransfer;
	}

	public void setResponseTransfer(ResponseTransfer responseTransfer) {
		this.responseTransfer = responseTransfer;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public void update(ResponseTransfer responseTransfer) {
		// TODO Auto-generated method stub
		this.responseTransfer = responseTransfer;
	}

}
