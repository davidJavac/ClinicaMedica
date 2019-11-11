package com.clinica.ClinicaMedica.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.ClinicaMedica.DTO.UsuarioDTO;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.service.UserService;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> loggin(@RequestBody UsuarioDTO usuarioDTO){
		
		Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
		
		Optional<Usuario> optional = userService.buscarUsuarioPorNombreUsuarioYPassword(usuario.getNombreUsuario(), 
				usuario.getPassword());
		
		if(optional.isPresent()) 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bienvenido " + optional.get().getNombreUsuario());
		else
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Usuario no registrado");
		
	}
}
