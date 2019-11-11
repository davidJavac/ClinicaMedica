package com.clinica.ClinicaMedica.DTO;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class UsuarioDTO implements Serializable{

	private Long id;
	@Size(max = 30, min = 1, message = "El campo nombreUsuario solo debe contener una cantidad de caracteres en el rango de 1-30")
	private String nombreUsuario;
	@Size(max = 50, min = 8, message = "El campo password solo debe contener una cantidad de caracteres en el rango de 8-50")
	private String password;
	@Size(max = 50, min = 1, message = "El campo nombre solo debe contener una cantidad de caracteres en el rango de 1-50")
	private String nombre;
	@Range(max = 50000000, min = 1, message = "El dni debe estar en el rango de 1-50000000")
	private int dni;
	@Size(max = 50, min = 1, message = "El campo dirección solo debe contener una cantidad de caracteres en el rango de 1-50")
	private String direccion;
	@Size(max = 10, min = 10, message = "El campo teléfono solo debe contener 10 digitos")
	private String telefono;
		
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Long getId() {
		return id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
