package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.Receta;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.repository.PacienteRepository;
import com.clinica.ClinicaMedica.repository.RecetaRepository;

@Service
@Qualifier("recetaService")
public class RecetaService implements Operacionable {

	@Autowired
	private RecetaRepository recetaRepository;
	@Autowired
	private PacienteRepository pacienteRepository;

	public RecetaService() {
	}

	@Override
	public Optional buscar(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional registrar(Object t) throws BusinessException{
		// TODO Auto-generated method stub

		Receta receta = (Receta) t;
		Long id = receta.getPaciente().getId();
		Optional<Paciente> optional_paciente = pacienteRepository.findById(id);

		if (optional_paciente.isPresent()) {
			
			try {
				
				Receta receta_registered = recetaRepository.save(receta);
				receta_registered.setPaciente(optional_paciente.get());
				
				ResponseTransfer<Receta> rt = new ResponseTransfer("La receta se ha guardado con éxito", receta_registered);
				
				return Optional.of(rt);
			}
			catch(Exception e) {
				
				return Optional.empty();
			}
			
		}
		else throw new BusinessException("No existe un paciente con el Id solicitado", null);
			
	}

	@Override
	public Optional modificar(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional eliminar(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional accept(Visitor visitor) throws BusinessException {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
