package com.clinica.ClinicaMedica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.clinica.ClinicaMedica.model.Especialidad;
import com.clinica.ClinicaMedica.repository.EspecialidadRepository;

@Component
public class DBInitializer implements CommandLineRunner{

	private EspecialidadRepository especialidadRepository;
	
	public DBInitializer(EspecialidadRepository especialidadRepository) {
		
		this.especialidadRepository = especialidadRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Especialidad cardiologia = new Especialidad("Cardiologia", 20);
		Especialidad urologia = new Especialidad("Urologia", 5);
		Especialidad reumatologia = new Especialidad("Reumatologia", 10);
		List<Especialidad> especialidades = new ArrayList<>();
		Collections.addAll(especialidades, cardiologia, urologia, reumatologia);
		especialidadRepository.saveAll(especialidades);
	}

}
