package com.clinica.ClinicaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Paciente;
import com.clinica.ClinicaMedica.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long>{

	@Query(value = "Select case when count(t) > 0 then true else false end from Turno t where "
			+ "(((:hora_termino between t.hora_inicio and t.hora_termino) or" + 
			 "(:hora_inicio between t.hora_inicio and t.hora_termino)) and t.fecha = :fecha) and "
			 + "(t.n_consultorio = :n_consultorio or t.medico = :medico)")
	boolean existsByFechaAndHora_inicioAndHora_terminoAndN_consultorioAndMedico(@Param("fecha")java.time.LocalDate fecha, 
			@Param("hora_inicio")java.util.Date hora_inicio, 
			@Param("hora_termino")java.util.Date hora_termino, @Param("n_consultorio") int n_consultorio,
			@Param("medico") Medico medico);

	@Query("Select t from Turno t where t.medico = :medico")
	boolean existsByMedico(@Param("medico")Medico medico);

	@Query("Select count(t) from Turno t where t.paciente =:paciente and t.asistencia = 'ausente'")
	Integer cantidadInasistenciasPaciente(@Param("paciente") Paciente paciente);
	
}
