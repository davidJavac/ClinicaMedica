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

import com.clinica.ClinicaMedica.DTO.RecetaDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Receta;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.service.RecetaService;

@RestController
@RequestMapping("api/v1")
public class RecetaController {

	@Autowired
	private RecetaService recetaService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/receta")
	public ResponseEntity<ResponseTransfer> registrarReceta(@RequestBody RecetaDTO recetaDTO)  throws BusinessException {
		
		Receta receta = mapper.map(recetaDTO, Receta.class);
		
		Optional<ResponseTransfer<Receta>> optional = recetaService.registrar(receta);
		
		if(optional.isPresent()) 
			return new ResponseEntity<>(optional.get(), HttpStatus.CREATED);
		else {
			ResponseTransfer rt = new ResponseTransfer("Error al intentar registrar la receta", null);
			return new ResponseEntity<ResponseTransfer>(rt, HttpStatus.BAD_REQUEST);
		}
			
	}

}
