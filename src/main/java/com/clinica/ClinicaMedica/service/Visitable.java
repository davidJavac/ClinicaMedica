package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.model.BusinessException;

public interface Visitable {

	public Optional<?> accept(Visitor visitor) throws BusinessException;
}
