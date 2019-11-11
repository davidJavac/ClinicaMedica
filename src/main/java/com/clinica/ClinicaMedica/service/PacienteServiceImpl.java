package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public Optional<Paciente> buscarPaciente(Long id) {
		// TODO Auto-generated method stub
		try {
			
			return Optional.of(pacienteRepository.findById(id).get()) ;
			
		}
		catch(Exception e) {
			
			return Optional.empty();
		}
	}

}
