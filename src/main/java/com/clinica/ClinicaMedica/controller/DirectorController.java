package com.clinica.ClinicaMedica.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.ClinicaMedica.DTO.DirectorDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Director;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.service.UserService;

@RestController
@RequestMapping("api/v1")
public class DirectorController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/director")
	public ResponseEntity<ResponseTransfer> registrarDirector(@Valid @RequestBody DirectorDTO directorDTO) throws BusinessException{
		
		Director director = mapper.map(directorDTO, Director.class);
		
		Optional<ResponseTransfer<Usuario>> optional = userService.registrarUsuario(director);
		
		if(optional.isPresent()) {
			
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		}
		else {
			ResponseTransfer rt = new ResponseTransfer("Error al intentar registrar el usuario", null);
			return new ResponseEntity<ResponseTransfer>(rt, HttpStatus.BAD_REQUEST);
		}
			
		
	}

}
