package com.clinica.ClinicaMedica.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Especialidad;
import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Turno;
import com.clinica.ClinicaMedica.repository.EspecialidadRepository;
import com.clinica.ClinicaMedica.repository.MedicoRepository;
import com.clinica.ClinicaMedica.repository.PacienteRepository;
import com.clinica.ClinicaMedica.repository.PrestacionRepository;
import com.clinica.ClinicaMedica.repository.TurnoRepository;

@Service
@Qualifier("turnoService")
public class TurnoService implements Operacionable{

	@Autowired
	private TurnoRepository turnoRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private PrestacionRepository prestacionRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	private Map<String, Object> fields;
	
	public Map<String, Object> getFields() {
		return fields;
	}

	public TurnoRepository getTurnoRepository() {
		return turnoRepository;
	}

	public MedicoRepository getMedicoRepository() {
		return medicoRepository;
	}

	public PacienteRepository getPacienteRepository() {
		return pacienteRepository;
	}

	public PrestacionRepository getPrestacionRepository() {
		return prestacionRepository;
	}

	public void setTurnoRepository(TurnoRepository turnoRepository) {
		this.turnoRepository = turnoRepository;
	}

	public void setMedicoRepository(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}

	public void setPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	public void setPrestacionRepository(PrestacionRepository prestacionRepository) {
		this.prestacionRepository = prestacionRepository;
	}

	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}

	public TurnoService() {}

	@Override
	public Optional buscar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		Turno turno = (Turno)t;
		Optional<Turno> optional_turno = turnoRepository.findById(turno.getId());
		
		if(optional_turno.isPresent()) {
			
			ResponseTransfer rt = new ResponseTransfer("" , optional_turno.get());
			return Optional.of(rt);
		}
		else
			throw new BusinessException("El turno solicitado no está registrado en el sistema", null);
		
	}

	@Override
	public Optional registrar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		Turno turno = (Turno)t;
		java.time.LocalDate hoy = java.time.LocalDate.now();
		java.time.LocalDate fecha = turno.getFecha();
					
		boolean before = fecha.isBefore(hoy);
		
		if(!turnoRepository.existsByFechaAndHora_inicioAndHora_terminoAndN_consultorioAndMedico(turno.getFecha(), 
				turno.getHora_inicio(), turno.getHora_termino(), turno.getN_consultorio(), turno.getMedico()) &&
				!before) {	
			
			Optional<Medico> optional_medico = medicoRepository.findById(turno.getMedico().getId()); 
			Optional<Paciente> optional_paciente = pacienteRepository.findById(turno.getPaciente().getId());
			Optional<Especialidad> optional_especialidad = especialidadRepository.findById(turno.getPrestacion().getEspecialidad().
					getId_especialidad());
			
			if(!optional_medico.isPresent()) throw new BusinessException("No existe un médico con el Id solicitado en el sistema", null);
			if(!optional_paciente.isPresent()) throw new BusinessException("No existe un paciente con el Id solicitado", null);
			if(!optional_especialidad.isPresent()) throw new BusinessException("No existe una especialidad"
					+ " con el Id solicitado", null);

			Especialidad especialidad = optional_especialidad.get();
			if(especialidad.getCantidad_turnos()>0) especialidad.setCantidad_turnos(especialidad.getCantidad_turnos() -1);
			else throw new BusinessException("No hay turnos disponibles para la especialidad " + especialidad.getNombre(), null);
			
			Turno turno_registered = Optional.of(turnoRepository.save(turno)).get();
			turno_registered.setMedico(optional_medico.get());
			turno_registered.setPaciente(optional_paciente.get());
			turno_registered.getPrestacion().setEspecialidad(especialidad);
			turno_registered.getMedico().setEspecialidad(especialidad);
			

			Turno turno_success = turnoRepository.findById(turno_registered.getId()).get();  
			ResponseTransfer rt = new ResponseTransfer("El turno se ha registrado con éxito", turno_success);
			
			return Optional.of(rt); 				
				
		}
		else 
			throw new BusinessException("No se cuenta con disponibilidad para registrar el turno", null);

	}

	@Override
	public Optional<ResponseTransfer<Turno>> modificar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		
		Turno turno = (Turno) t; 
		Optional<Turno> optional_turno = turnoRepository.findById(turno.getId());
		
		if(optional_turno.isPresent()) {
			Turno turno_fetched = optional_turno.get(); 
			turno_fetched.setAsistencia(turno.getAsistencia());
			Turno turno_update = turnoRepository.save(turno_fetched);
			ResponseTransfer<Turno> rt = new ResponseTransfer("Se ha actualizado el turno exitosamente" , turno_update);
			return Optional.of(rt);
			
		}
		else
			throw new BusinessException("El turno solicitado no está registrado", null);			
					
	}

	@Override
	public Optional eliminar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional accept(Visitor visitor) throws BusinessException{
		// TODO Auto-generated method stub	
		TurnoServiceEvento serviceEvento = (TurnoServiceEvento) visitor;
		serviceEvento.setSujetoEvento(new SujetoEventoTurno());
		return visitor.visit(this);
	}


}
