package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.model.Paciente;

public interface PacienteService {

	public Optional<Paciente> buscarPaciente(Long id);
}
