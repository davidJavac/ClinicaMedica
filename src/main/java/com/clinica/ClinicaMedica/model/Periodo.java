package com.clinica.ClinicaMedica.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Periodo {
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fecha_desde;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fecha_hasta;
	public LocalDate getFecha_desde() {
		return fecha_desde;
	}
	public LocalDate getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_desde(LocalDate fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public void setFecha_hasta(LocalDate fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	
}
