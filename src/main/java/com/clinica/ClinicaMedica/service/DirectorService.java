package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.model.Director;

public interface DirectorService {
	
	public Optional<Director> buscarDirector(Long id);
}
