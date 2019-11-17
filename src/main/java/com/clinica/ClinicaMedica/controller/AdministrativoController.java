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

import com.clinica.ClinicaMedica.DTO.AdministrativoDTO;
import com.clinica.ClinicaMedica.model.Administrativo;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.AdministrativoRepository;
import com.clinica.ClinicaMedica.service.UserService;

@RestController
@RequestMapping("api/v1")
public class AdministrativoController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AdministrativoRepository administrativoRepository;
	
	@PostMapping("/administrativo/{id}")
	public ResponseEntity<Administrativo> buscarAdministrativo(@PathVariable("id") String id ) throws BusinessException{
		
		Optional<Administrativo> optional_administrativo = administrativoRepository.findById(Long.parseLong(id));
		
		if(optional_administrativo.isPresent())
			return new ResponseEntity<>(optional_administrativo.get(), HttpStatus.CREATED);
		else
			throw new BusinessException("No se ha encontrado el administrativo en la bd", null);
	}

	
	@PostMapping("/administrativo")
	public ResponseEntity<ResponseTransfer> registrarAdministrativo(@Valid @RequestBody AdministrativoDTO administrativoDTO) throws BusinessException{
		
		//Administrativo administrativo = mapper.map(administrativoDTO, Administrativo.class);
		
		Optional<ResponseTransfer<Usuario>> optional = userService.registrarUsuario(administrativoDTO);
		if(optional.isPresent()) {
			
			return new ResponseEntity<>(optional.get(), HttpStatus.CREATED);
		}
		else {
			ResponseTransfer rt = new ResponseTransfer("Error al intentar registrar el usuario", null);
			return new ResponseEntity<ResponseTransfer>(rt, HttpStatus.BAD_REQUEST);
		}
	}

}
