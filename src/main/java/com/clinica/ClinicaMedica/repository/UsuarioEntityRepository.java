package com.clinica.ClinicaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Usuario;

@Repository
public interface UsuarioEntityRepository extends JpaRepository<Usuario, Long>{

}
