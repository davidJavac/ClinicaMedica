package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.DTO.UsuarioDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;

public interface UserService {

	public Optional<ResponseTransfer<Usuario>> registrarUsuario(UsuarioDTO usuarioDTO)throws BusinessException;
	public Optional<ResponseTransfer<Usuario>> buscarUsuarioPorId(Long id) throws BusinessException;
	public Optional<Usuario> buscarUsuarioPorNombreUsuarioYPassword(String nombreUsuario, String password);
}
