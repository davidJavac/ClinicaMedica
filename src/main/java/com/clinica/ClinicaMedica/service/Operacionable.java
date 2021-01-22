package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import com.clinica.ClinicaMedica.model.BusinessException;

public interface Operacionable<T> extends Visitable{
	public Optional<?> buscar(T t) throws BusinessException;//comment
	public Optional<?> registrar(T t) throws BusinessException;
	public Optional<?> modificar(T t) throws BusinessException;
	public Optional<?> eliminar(T t) throws BusinessException;
}
