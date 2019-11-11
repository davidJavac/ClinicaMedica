package com.clinica.ClinicaMedica.DTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecetaDTO{

	private Long id;

	private PacienteDTO paciente;
	@Size(max = 100, min = 1, message = "El campo diagnóstico solo debe contener una cantidad de caracteres en el rango de 1-100")
	private String diagnostico;
	@Size(max = 100, min = 1, message = "El campo medicamento solo debe contener una cantidad de caracteres en el rango de 1-100")
	private String medicamento;
	@Size(max = 100, min = 1, message = "El campo posología solo debe contener una cantidad de caracteres en el rango de 1-100")
	private String posologia;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private java.util.Date fecha;
	public Long getId() {
		return id;
	}
	public PacienteDTO getPaciente() {
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
	public void setPaciente(PacienteDTO paciente) {
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
