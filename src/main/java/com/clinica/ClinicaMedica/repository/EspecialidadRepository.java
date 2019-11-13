package com.clinica.ClinicaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Especialidad;
import com.clinica.ClinicaMedica.model.Paciente;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>{

}
