package com.clinica.ClinicaMedica.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.AbonoTarjetaCredito;
import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.Prestacion;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.repository.AbonoTarjetaCreditoRepository;
import com.clinica.ClinicaMedica.repository.PacienteRepository;
import com.clinica.ClinicaMedica.repository.PrestacionRepository;

@Service
@Qualifier("tarjetaCreditoService")
public class TarjetaCreditoService implements Operacionable<AbonoTarjetaCredito>{

	@Autowired
	private AbonoTarjetaCreditoRepository abonoTarjetaCreditoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private PrestacionRepository prestacionRepository;
	
	public TarjetaCreditoService() {}

	@Override
	public Optional accept(Visitor visitor) throws BusinessException{
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

	@Override
	public Optional<?> buscar(AbonoTarjetaCredito t) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ResponseTransfer> registrar(AbonoTarjetaCredito t) throws BusinessException {
		// TODO Auto-generated method stub
		ResponseTransfer<AbonoTarjetaCredito> rt;
		AbonoTarjetaCredito atc = (AbonoTarjetaCredito)t;
		
		LocalDate hoy = LocalDate.now();
		
		if(atc.getVencimiento().isBefore(hoy)) {
			throw new BusinessException("La tarjeta de crédito ha caducado. Fecha de vencimiento: " + atc.getVencimiento(), null);
		}
		else {
			
			Optional<Paciente> optional_paciente = pacienteRepository.findById(atc.getPaciente().getId());
			Optional<Prestacion> optional_prestacion = prestacionRepository.findById(atc.getPrestacion().getId());
			
			if(!optional_paciente.isPresent()) throw new BusinessException("No existe el paciente solicitado", null);
			if(!optional_prestacion.isPresent()) throw new BusinessException("No existe la prestación solicitada", null);
			
			Paciente paciente = optional_paciente.get();
			Prestacion prestacion = optional_prestacion.get();
			if(atc.getDni_titular()!=paciente.getDni())
				throw new BusinessException("El dni del titular de la tarjeta aportado no coincide con el dni del paciente", null);
			else {
				
				try {
					
					AbonoTarjetaCredito atc_registered = abonoTarjetaCreditoRepository.save(atc); 
					atc_registered.setPaciente(paciente);
					atc_registered.setFecha_pago(hoy);
					atc_registered.setPrestacion(prestacion);
					
					rt = new ResponseTransfer("El pago se ha realizado con éxito", atc_registered);
					return Optional.of(rt) ; 				
					
				}
				catch(Exception e) {
					
					return Optional.empty();
				}
			}
					
		}

	}

	@Override
	public Optional<?> modificar(AbonoTarjetaCredito t) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<?> eliminar(AbonoTarjetaCredito t) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


}
