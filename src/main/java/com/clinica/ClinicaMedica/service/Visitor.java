package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.model.BusinessException;

public interface Visitor {

	public Optional<?> visit(Operacionable operacionable) throws BusinessException;
}
