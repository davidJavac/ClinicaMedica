package com.clinica.ClinicaMedica.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Prestacion;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.MedicoRepository;
import com.clinica.ClinicaMedica.repository.PrestacionRepository;

@Service
@Qualifier("reporteMedico")
public class MedicoServiceImpl implements UserReportable {

	@Autowired
	MedicoRepository medicoRepository;
	@Autowired
	PrestacionRepository prestacionRepository;
	
	@Override
	public Optional reportePorFecha(Usuario usuario, LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional reportePorPeriodo(Usuario usuario, LocalDate fecha_desde, LocalDate fecha_hasta) throws BusinessException{
		// TODO Auto-generated method stub
		Medico medico = (Medico) usuario;
	
		Optional<List<Prestacion>> optional_prestaciones = prestacionRepository.prestacionesPorMedicoPeriodo(medico, fecha_desde, fecha_hasta);
		
		if(optional_prestaciones.isPresent()) {
			
			String message = "Cantidad de prestaciones en el último mes brindadas por el médico " + medico.getNombre() + 
					" matrícula " + medico.getMatricula() + ": " + optional_prestaciones.get().size();
			
			ResponseTransfer<List<Prestacion>> rt = new ResponseTransfer<List<Prestacion>>(message , optional_prestaciones.get());
			return Optional.of(rt);
		}
		else
			throw new BusinessException("No se han encontrado prestaciones brindadas por el médico solicitado", null);
		
	}

}
