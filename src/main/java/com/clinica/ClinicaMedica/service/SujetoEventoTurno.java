package com.clinica.ClinicaMedica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;

public class SujetoEventoTurno implements Subject {

	private List<UsuarioObserver> usuariosObserver;

	private Usuario usuario;
	
	public List<UsuarioObserver> getUsuariosObserver() {
		return usuariosObserver;
	}

	public void setUsuariosObserver(List<UsuarioObserver> usuariosObserver) {
		this.usuariosObserver = usuariosObserver;
	}


	public SujetoEventoTurno() {
		
		this.usuariosObserver = new ArrayList<UsuarioObserver>();
	}

	@Override
	public void attach(UsuarioObserver observer) {
		// TODO Auto-generated method stub
		usuariosObserver.add(observer);
	}

	@Override
	public void dettach(UsuarioObserver observer) {
		// TODO Auto-generated method stub
		usuariosObserver.remove(observer);
	}

	@Override
	public Optional<List<UsuarioObserver>> notifyObservers(Usuario usuario) {
		// TODO Auto-generated method stub

		for (UsuarioObserver uo : usuariosObserver) {

			ResponseTransfer rt = new ResponseTransfer("El paciente presenta 3 o mas inasistencias en el sistema",
					usuario);

			uo.update(rt);
		}
		
		return !usuariosObserver.isEmpty() ? Optional.of(usuariosObserver) : Optional.empty();
	}

}
