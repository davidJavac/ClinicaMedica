package com.clinica.ClinicaMedica.DTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.clinica.ClinicaMedica.model.Prestacion;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TurnoDTO{
	
	private Long id;
	
	private MedicoDTO medico;
	
	private PacienteDTO paciente;

//	private PrestacionDTO prestacion;
	private Prestacion prestacion;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private java.time.LocalDate fecha;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private java.util.Date hora_inicio;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private java.util.Date hora_termino;
	@Range(max = 50, min = 1, message = "El número de consultorio solo puede estar en el rango de 1-50")
	private int n_consultorio;
	@Size(max = 15, min = 1, message= "El campo asistencia no puede estar vacío y debe tener un máximo de 15 caracteres")
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
		
	/*public PrestacionDTO getPrestacion() {
		return prestacion;
	}
	
	
	public void setPrestacion(PrestacionDTO prestacion) {
		this.prestacion = prestacion;
	}*/

	public Prestacion getPrestacion() {
		return prestacion;
	}
	
	
	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}
	
	public MedicoDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}
	public PacienteDTO getPaciente() {
		return paciente;
	}
	
	public void setPaciente(PacienteDTO paciente) {
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
