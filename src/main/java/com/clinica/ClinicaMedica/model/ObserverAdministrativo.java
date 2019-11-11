package com.clinica.ClinicaMedica.model;

import com.clinica.ClinicaMedica.service.UsuarioObserver;

public class ObserverAdministrativo implements UsuarioObserver{

	private ResponseTransfer responseTransfer;
	private Administrativo administrativo;
	
	public ObserverAdministrativo(Administrativo administrativo) {
		
		this.administrativo = administrativo;
	}
	
	public ResponseTransfer getResponseTransfer() {
		return responseTransfer;
	}

	public void setResponseTransfer(ResponseTransfer responseTransfer) {
		this.responseTransfer = responseTransfer;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	@Override
	public void update(ResponseTransfer responseTransfer) {
		// TODO Auto-generated method stub
		this.responseTransfer = responseTransfer;
	}

}
