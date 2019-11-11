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

import com.clinica.ClinicaMedica.DTO.PacienteDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.service.UserService;

@RestController
@RequestMapping("api/v1")
public class PacienteController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/paciente")
	public ResponseEntity<?> registrarPaciente(@RequestBody PacienteDTO pacienteDTO) throws BusinessException{
		
		Paciente paciente = mapper.map(pacienteDTO, Paciente.class);
		
		Optional<ResponseTransfer<Usuario>> optional = userService.registrarUsuario(paciente);
		if(optional.isPresent()) {
			
			return new ResponseEntity<>(optional.get(), HttpStatus.CREATED);
		}
		else {
			ResponseTransfer rt = new ResponseTransfer("Error al intentar registrar el usuario", null);
			return new ResponseEntity<ResponseTransfer>(rt, HttpStatus.BAD_REQUEST);
		}
	}

}
