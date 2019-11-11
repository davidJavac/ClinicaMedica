package com.clinica.ClinicaMedica.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Director")
@Table(name = "director")
public class Director extends Usuario{
	
}
