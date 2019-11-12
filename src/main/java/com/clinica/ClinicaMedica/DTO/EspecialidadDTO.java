package com.clinica.ClinicaMedica.DTO;

public class EspecialidadDTO{

	private Long id;
	private String nombre;
	private int cantidad_turnos;
	
	public int getCantidad_turnos() {
		return cantidad_turnos;
	}
	
	public void setCantidad_turnos(int cantidad_turnos) {
		this.cantidad_turnos = cantidad_turnos;
	}
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
