package com.clinica.ClinicaMedica.model;

import java.io.Serializable;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "receta")
public class Receta{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_receta")
	private Long id;
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "receta_paciente",
			joinColumns = @JoinColumn(name = "id_receta"),
			inverseJoinColumns = @JoinColumn(name = "id")
			)
	private Paciente paciente;
	private String diagnostico;
	private String medicamento;
	private String posologia;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private java.util.Date fecha;
	public Long getId() {
		return id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public String getMedicamento() {
		return medicamento;
	}
	public String getPosologia() {
		return posologia;
	}
	public java.util.Date getFecha() {
		return fecha;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	
}
