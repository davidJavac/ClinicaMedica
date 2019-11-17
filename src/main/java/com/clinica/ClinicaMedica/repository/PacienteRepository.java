package com.clinica.ClinicaMedica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	public Optional<Paciente> findById(Long id);
}
