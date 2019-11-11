package com.clinica.ClinicaMedica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Prestacion;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Turno;
import com.clinica.ClinicaMedica.repository.PrestacionRepository;

@Service
@Qualifier("prestacionService")
public class PrestacionService implements Operacionable{

	@Autowired
	private PrestacionRepository prestacionRepository;
	

	public PrestacionRepository getPrestacionRepository() {
		return prestacionRepository;
	}

	public void setPrestacionRepository(PrestacionRepository prestacionRepository) {
		this.prestacionRepository = prestacionRepository;
	}

	public PrestacionService() {}

	@Override
	public Optional registrar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<ResponseTransfer<Turno>> modificar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		
		return Optional.empty();					
	}

	@Override
	public Optional eliminar(Object t)  throws BusinessException{
		// TODO Auto-generated method stub
		return Optional.empty();					
	}

	@Override
	public Optional accept(Visitor visitor) throws BusinessException{
		// TODO Auto-generated method stub	
		return visitor.visit(this);
	}

	@Override
	public Optional buscar(Object t) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


}
