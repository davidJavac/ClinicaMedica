package com.clinica.ClinicaMedica.controller;

import java.util.List;
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

import com.clinica.ClinicaMedica.DTO.MedicoDTO;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.Periodo;
import com.clinica.ClinicaMedica.model.Prestacion;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.MedicoRepository;
import com.clinica.ClinicaMedica.service.UserReportable;
import com.clinica.ClinicaMedica.service.UserService;

@RestController
@RequestMapping("api/v1")
public class MedicoController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserReportable reporteMedico;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@PostMapping("/medico/{id}")
	public ResponseEntity<Medico> buscarMedico(@PathVariable("id") String id ) throws BusinessException{
		
		Optional<Medico> optional_medico = medicoRepository.findById(Long.parseLong(id));
		
		if(optional_medico.isPresent())
			return new ResponseEntity<>(optional_medico.get(), HttpStatus.CREATED);
		else
			throw new BusinessException("No se ha encontrado el medico en la bd", null);
	}
	
	@PostMapping("/medico")
	public ResponseEntity<ResponseTransfer> registrarMedico(@Valid @RequestBody MedicoDTO medicoDTO) throws BusinessException{
		
		//Medico medico = mapper.map(medicoDTO, Medico.class);

		Optional<ResponseTransfer<Usuario>> optional = userService.registrarUsuario(medicoDTO);
		if(optional.isPresent()) {
			
			return new ResponseEntity<>(optional.get(), HttpStatus.CREATED);
			
		}
		else {
			ResponseTransfer rt = new ResponseTransfer("Error al intentar registrar el usuario", null);
			return new ResponseEntity<ResponseTransfer>(rt, HttpStatus.BAD_REQUEST);
		}
	
			
	}
	
	@PostMapping("/reporte/reportePrestaciones/medico/{id}")
	public ResponseEntity<Object> reportePrestacionesPorMedico(@PathVariable("id")String id,
			@RequestBody Periodo periodo) throws BusinessException{
		
		Optional<ResponseTransfer<Usuario>> optional_medico = userService.buscarUsuarioPorId(Long.parseLong(id));
		
		if(optional_medico.isPresent() && optional_medico.get().getEntity() instanceof Medico) {
			
			Medico medico = (Medico) optional_medico.get().getEntity();
			
			Optional<ResponseTransfer<List<Prestacion>>> optional = (Optional<ResponseTransfer<List<Prestacion>>>) 
					reporteMedico.reportePorPeriodo(medico, 
					periodo.getFecha_desde(), periodo.getFecha_hasta());
			if(optional.isPresent())
				return new ResponseEntity<>((ResponseTransfer<List<Prestacion>>)optional.get(), HttpStatus.CREATED);
			else {
				
				ResponseTransfer rt = new ResponseTransfer("Error en la generación del reporte", null);
				return new ResponseEntity<>(rt, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		throw new BusinessException("No se ha encontrado el médico solicitado", null);
	}	


}
