package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.Administrativo;
import com.clinica.ClinicaMedica.repository.AdministrativoRepository;

@Service
public class AdministrativoServiceImpl implements AdministrativoService {

	@Autowired
	AdministrativoRepository administrativoRepository;

	@Override
	public Optional<Administrativo> buscarAdministrativo(Long id) {
		// TODO Auto-generated method stub
		try {
			
			return Optional.empty();
			
		}
		catch(Exception e) {
			
			return Optional.empty();
		}
	}

}
