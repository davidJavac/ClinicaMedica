package com.clinica.ClinicaMedica.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends Usuario implements Serializable{
	
	/*@OneToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "medico_especialidad",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_especialidad")
			)*/
	/*@OneToMany(
	        mappedBy = "medico",
	        cascade = CascadeType.MERGE,
	        orphanRemoval = true
	    )*/
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "medico_especialidad",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_especialidad")
			)
	/*@ManyToOne(
	          fetch = FetchType.LAZY,
	          optional = false
	  )
	  @JoinColumn(
	          name = "id_especialidad",
	          nullable = false
	  )*/
	/*@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_especialidad")*/
	private Especialidad especialidad;
	private String matricula;
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
