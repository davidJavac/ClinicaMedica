package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.model.Administrativo;

public interface AdministrativoService {

	public Optional<Administrativo> buscarAdministrativo(Long id);
}
