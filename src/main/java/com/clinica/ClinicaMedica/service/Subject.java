package com.clinica.ClinicaMedica.service;

import java.util.List;
import java.util.Optional;

import com.clinica.ClinicaMedica.model.Usuario;

public interface Subject {

	public void attach(UsuarioObserver observer);
	public void dettach(UsuarioObserver observer);
	public Optional<List<UsuarioObserver>> notifyObservers(Usuario usuario);
}
