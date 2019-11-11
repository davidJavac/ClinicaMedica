package com.clinica.ClinicaMedica.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estudio")
public class Estudio extends Prestacion implements Serializable{

	private String nombre;
	private String prediagnostico;
	public String getNombre() {
		return nombre;
	}
	public String getPrediagnostico() {
		return prediagnostico;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrediagnostico(String prediagnostico) {
		this.prediagnostico = prediagnostico;
	}
	
}
