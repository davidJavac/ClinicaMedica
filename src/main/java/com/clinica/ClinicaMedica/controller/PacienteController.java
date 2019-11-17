package com.clinica.ClinicaMedica.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.ClinicaMedica.DTO.PacienteDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.PacienteRepository;
import com.clinica.ClinicaMedica.service.UserService;

@RestController
@RequestMapping("api/v1")
public class PacienteController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@PostMapping("/paciente/{id}")
	public ResponseEntity<Paciente> buscarPaciente(@PathVariable("id") String id ) throws BusinessException{
		
		Optional<Paciente> optional_paciente = pacienteRepository.findById(Long.parseLong(id));
		
		if(optional_paciente.isPresent())
			return new ResponseEntity<>(optional_paciente.get(), HttpStatus.CREATED);
		else
			throw new BusinessException("No se ha encontrado el paciente en la bd", null);
	}
	
	@PostMapping("/paciente")
	public ResponseEntity<?> registrarPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) throws BusinessException{
		
		//Paciente paciente = mapper.map(pacienteDTO, Paciente.class);
		
		Optional<ResponseTransfer<Usuario>> optional = userService.registrarUsuario(pacienteDTO);
		if(optional.isPresent()) {
			
			return new ResponseEntity<>(optional.get(), HttpStatus.CREATED);
		}
		else {
			ResponseTransfer rt = new ResponseTransfer("Error al intentar registrar el usuario", null);
			return new ResponseEntity<ResponseTransfer>(rt, HttpStatus.BAD_REQUEST);
		}
	}

}
