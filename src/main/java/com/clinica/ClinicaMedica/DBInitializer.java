package com.clinica.ClinicaMedica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.clinica.ClinicaMedica.model.Especialidad;
import com.clinica.ClinicaMedica.repository.EspecialidadRepository;
import com.clinica.ClinicaMedica.repository.PacienteRepository;

@Component
public class DBInitializer implements CommandLineRunner{

	private EspecialidadRepository especialidadRepository;
	private PacienteRepository pacienteRepository;
	
	public DBInitializer(EspecialidadRepository especialidadRepository) {
		
		this.especialidadRepository = especialidadRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Especialidad cardiologia = new Especialidad();
		cardiologia.setNombre("Cardiologia");
		cardiologia.setCantidad_turnos(3);
		Especialidad urologia = new Especialidad();
		urologia.setNombre("Urologia");
		urologia.setCantidad_turnos(2);
		Especialidad reumatologia = new Especialidad();
		reumatologia.setNombre("Reumatologia");
		reumatologia.setCantidad_turnos(2);
		List<Especialidad> especialidades = new ArrayList<>();
		Collections.addAll(especialidades, cardiologia, urologia, reumatologia);
		especialidadRepository.saveAll(especialidades);
		
		
		
	}

}
