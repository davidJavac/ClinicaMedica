package com.clinica.ClinicaMedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Administrativo;
import com.clinica.ClinicaMedica.model.Usuario;

@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Long>{

}
