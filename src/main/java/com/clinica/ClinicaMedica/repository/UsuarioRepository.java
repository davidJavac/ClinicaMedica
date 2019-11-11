package com.clinica.ClinicaMedica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByNombreUsuarioAndPassword(String nombreUsuario, String password);
	public boolean existsByNombreUsuario(String nombreUsuario);
}
