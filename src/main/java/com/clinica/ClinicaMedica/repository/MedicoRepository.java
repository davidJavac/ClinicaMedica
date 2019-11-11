package com.clinica.ClinicaMedica.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Prestacion;
import com.clinica.ClinicaMedica.model.Usuario;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
