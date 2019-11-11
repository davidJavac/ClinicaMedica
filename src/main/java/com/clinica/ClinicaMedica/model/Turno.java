package com.clinica.ClinicaMedica.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "Turno")
@Table(name = "turno")
@DynamicUpdate(true)
public class Turno{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_turno")
	private Long id;
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "turno_medico",
			joinColumns = @JoinColumn(name = "id_turno"),
			inverseJoinColumns = @JoinColumn(name = "id")
			)
	private Medico medico;
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "turno_paciente",
			joinColumns = @JoinColumn(name = "id_turno"),
			inverseJoinColumns = @JoinColumn(name = "id_paciente")
			)
	private Paciente paciente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Prestacion prestacion;

	//@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private java.time.LocalDate fecha;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private java.util.Date hora_inicio;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private java.util.Date hora_termino;
	private int n_consultorio;
	private String asistencia;
	
	public String getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public Long getId() {
		return id;
	}
		
	public Prestacion getPrestacion() {
		return prestacion;
	}
	
	
	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getN_consultorio() {
		return n_consultorio;
	}


	public void setN_consultorio(int n_consultorio) {
		this.n_consultorio = n_consultorio;
	}



	public java.time.LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}

	public java.util.Date getHora_inicio() {
		return hora_inicio;
	}

	public java.util.Date getHora_termino() {
		return hora_termino;
	}

	public void setHora_inicio(java.sql.Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public void setHora_termino(java.sql.Date hora_termino) {
		this.hora_termino = hora_termino;
	}
	

}
