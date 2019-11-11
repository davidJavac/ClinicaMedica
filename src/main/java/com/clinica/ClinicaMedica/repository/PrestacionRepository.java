package com.clinica.ClinicaMedica.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.Prestacion;

@Repository
public interface PrestacionRepository extends JpaRepository<Prestacion, Long>{
	
	@Query("select p from Prestacion p inner join Turno t on p.id = t.prestacion and t.medico = :medico"
	+ " and (t.fecha between :fecha_desde and :fecha_hasta) and t.asistencia = 'presente'")
	Optional<List<Prestacion>> prestacionesPorMedicoPeriodo(@Param("medico") Medico medico, 
		@Param("fecha_desde")LocalDate fecha_desde, @Param("fecha_hasta") LocalDate fecha_hasta);
}
