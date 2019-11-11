package com.clinica.ClinicaMedica.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.Administrativo;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.ObserverAdministrativo;
import com.clinica.ClinicaMedica.model.ObserverMedico;
import com.clinica.ClinicaMedica.model.ObserverPaciente;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Turno;
import com.clinica.ClinicaMedica.model.Usuario;


public class TurnoServiceEvento implements Visitor{

	private Turno turno;
	
	private UserService userService;
	
	private Subject sujetoEvento;
	public Subject getSujetoEvento() {
		return sujetoEvento;
	}

	public void setSujetoEvento(Subject sujetoEvento) {
		this.sujetoEvento = sujetoEvento;
	}
	
	public void setTurno(Turno turno) {
		
		this.turno = turno;
	}
	
	@Autowired
	public TurnoServiceEvento(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Optional visit(Operacionable operacionable) throws BusinessException{
		// TODO Auto-generated method stub
		TurnoService turnoService = (TurnoService)operacionable;
		Optional<Paciente> optional_paciente = turnoService.getPacienteRepository().findById(turno.getPaciente().getId());
		
		if(optional_paciente.isPresent()) {
			
			Paciente paciente = optional_paciente.get();
			
			Integer cant_inasistencias = turnoService.getTurnoRepository().cantidadInasistenciasPaciente(paciente);
			
			if(cant_inasistencias >= 3) {
				

				if(optional_paciente.isPresent()) {
						
					UsuarioObserver usuario_paciente = new ObserverPaciente(paciente);  
					sujetoEvento.attach(usuario_paciente);
					
				}

				Arrays.asList(1L,15L,3L).forEach(e -> { // set Ids of users that will receive the event
					
						try {
							this.attachObservers(e);
						} catch (BusinessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				});
				
				
				return Optional.of(sujetoEvento.notifyObservers(paciente));
			}
			
		}
		
		return Optional.empty();
	}
	
	@SuppressWarnings("unchecked")
	public void attachObservers(Long id_usuario) throws BusinessException{
		
		Optional<ResponseTransfer<Usuario>> optional_usuario = userService.buscarUsuarioPorId(id_usuario);
		
		if(optional_usuario.isPresent()) {
			
			if(optional_usuario.get().getEntity() instanceof Medico) {
				
				UsuarioObserver usuario_medico = new ObserverMedico((Medico)optional_usuario.get().getEntity());  
				sujetoEvento.attach(usuario_medico);
			}
			if(optional_usuario.get().getEntity() instanceof Administrativo) {
				
				UsuarioObserver usuario_administrativo = new 
						ObserverAdministrativo((Administrativo)optional_usuario.get().getEntity());  
				sujetoEvento.attach(usuario_administrativo);
			}
		}
		
	}

}
