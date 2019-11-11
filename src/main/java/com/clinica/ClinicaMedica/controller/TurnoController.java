package com.clinica.ClinicaMedica.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.ClinicaMedica.DTO.TurnoDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Turno;
import com.clinica.ClinicaMedica.service.Operacionable;
import com.clinica.ClinicaMedica.service.TurnoServiceEvento;
import com.clinica.ClinicaMedica.service.UserService;
import com.clinica.ClinicaMedica.service.UsuarioObserver;

@RestController
@RequestMapping("api/v1")
public class TurnoController {

	@Autowired
	private Operacionable turnoService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/turno")
	public ResponseEntity<Object> registrarTurno(@RequestBody TurnoDTO turnoDTO)  throws BusinessException {
		
		Turno turno = mapper.map(turnoDTO, Turno.class);
		
		Optional<ResponseTransfer> optional = (Optional<ResponseTransfer>) turnoService.registrar(turno);
		
		if(optional.isPresent()) 
			return new ResponseEntity<>((ResponseTransfer)optional.get(), HttpStatus.CREATED);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se ha generado un error al momento de registrar el turno");
		
	}
	
	@PutMapping("/turno/asistencia/{id}")
	public ResponseEntity<ResponseTransfer> asistenciaPacienteTurno(@RequestBody TurnoDTO turnoDTO,
			@PathVariable("id") String id)  throws BusinessException {
		
		Turno turno = mapper.map(turnoDTO, Turno.class);
		
		turno.setId(Long.parseLong(id));

		Optional<ResponseTransfer<Turno>> optional = turnoService.modificar(turno);
		if(optional.isPresent()) {

			ResponseTransfer<Turno> rt_turno = optional.get();
			
			Turno turno_updated = rt_turno.getEntity();
			TurnoServiceEvento serviceEvento = new TurnoServiceEvento(userService);
			serviceEvento.setTurno(turno_updated);
			Optional<List<UsuarioObserver>> respuesta_evento = (Optional<List<UsuarioObserver>>) turnoService.accept(serviceEvento);
			if(respuesta_evento.isPresent()) {
				
				ResponseTransfer rt_evento = new ResponseTransfer("Lista de usuarios informados del evento", respuesta_evento.get());
				return new ResponseEntity<>(rt_evento, HttpStatus.OK);
			}
			else {
				
				return new ResponseEntity<>(rt_turno, HttpStatus.CREATED);
			}
		}
				
		ResponseTransfer<Turno> rt = new ResponseTransfer("Error en el registro de la asistencia", null);
		return new ResponseEntity<>(rt, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
