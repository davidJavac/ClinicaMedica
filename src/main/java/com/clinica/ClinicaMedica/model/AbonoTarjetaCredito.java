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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "abonoTarjetaCredito")
public class AbonoTarjetaCredito{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_abonoTarjetaCredito")
	private Long id;
	@Size(max = 15, min = 1, message= "El campo marca no puede estar vacío y debe tener un máximo de 15 caracteres")
	private String marca;
	@Size(max = 19, min = 19, message= "El campo numero_tarjeta no puede estar vacío y debe tener un máximo de 16 digitos")
	private String numero_tarjeta;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private java.time.LocalDate vencimiento;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private java.time.LocalDate fecha_pago;
	private String titular_tarjeta;
	private int dni_titular;
	private int pagos;
	private double monto;
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "abono_paciente",
			joinColumns = @JoinColumn(name = "id_abonoTarjetaCredito"),
			inverseJoinColumns = @JoinColumn(name = "id")
			)
	private Paciente paciente;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name = "tarjeta_prestacion",
			joinColumns = @JoinColumn(name = "id_abonoTarjetaCredito"),
			inverseJoinColumns = @JoinColumn(name = "id_prestacion")
			)
	private Prestacion prestacion;
	
	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getPagos() {
		return pagos;
	}

	public double getMonto() {
		return monto;
	}

	public void setPagos(int pagos) {
		this.pagos = pagos;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public String getTitular_tarjeta() {
		return titular_tarjeta;
	}

	public int getDni_titular() {
		return dni_titular;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public java.time.LocalDate getVencimiento() {
		return vencimiento;
	}

	public java.time.LocalDate getFecha_pago() {
		return fecha_pago;
	}

	public void setVencimiento(java.time.LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	public void setFecha_pago(java.time.LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public void setTitular_tarjeta(String titular_tarjeta) {
		this.titular_tarjeta = titular_tarjeta;
	}

	public void setDni_titular(int dni_titular) {
		this.dni_titular = dni_titular;
	}
		
}
