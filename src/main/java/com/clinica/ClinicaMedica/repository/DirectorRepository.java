package com.clinica.ClinicaMedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Director;
import com.clinica.ClinicaMedica.model.Usuario;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{

}
