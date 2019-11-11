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

import com.clinica.ClinicaMedica.DTO.AbonoTarjetaCreditoDTO;
import com.clinica.ClinicaMedica.model.AbonoTarjetaCredito;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.service.Operacionable;

@RestController
@RequestMapping("api/v1")
public class TarjetaCreditoController {

	@Autowired
	private Operacionable tarjetaCreditoService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/tarjetaCredito/pagoPrestacion")
	public ResponseEntity<ResponseTransfer> registrarPagoPrestacion(@Valid @RequestBody AbonoTarjetaCreditoDTO atcDTO) throws BusinessException{
		
		AbonoTarjetaCredito atc = mapper.map(atcDTO, AbonoTarjetaCredito.class);
		
		Optional<ResponseTransfer> optional = tarjetaCreditoService.registrar(atc);
		if(optional.isPresent())
			return new ResponseEntity<>(optional.get(), HttpStatus.CREATED);
		else {
			
			ResponseTransfer<AbonoTarjetaCredito> rt = new ResponseTransfer("Error en el registro del pago", null);
			return new ResponseEntity<>(rt, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
