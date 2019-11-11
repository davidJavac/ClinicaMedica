package com.clinica.ClinicaMedica.service;

import java.time.LocalDate;
import java.util.Optional;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Usuario;

public interface UserReportable {

	public Optional<?> reportePorFecha(Usuario usuario, LocalDate fecha) throws BusinessException;
	public Optional<?> reportePorPeriodo(Usuario usuario ,LocalDate fecha_desde, LocalDate fecha_hasta)throws BusinessException;
	
}
