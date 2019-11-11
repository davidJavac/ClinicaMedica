package com.clinica.ClinicaMedica.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AbonoTarjetaCreditoDTO{

	
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
	@Range(max = 50000000, min = 1, message = "El dni debe estar en el rango de 1-50000000")
	private int dni_titular;
	@Range(max = 12, min = 1, message = "La cantidad de pagos solo puede estar en el rango de 1-12")
	private int pagos;
	@Range(max = 1000000, min = 1, message = "El monto solo puede estar en el rango de 1-100000")
	private double monto;
	private PacienteDTO paciente;
	
	private PrestacionDTO prestacion;
	
	public PrestacionDTO getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(PrestacionDTO prestacion) {
		this.prestacion = prestacion;
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
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
