package com.clinica.ClinicaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.ClinicaMedica.model.AbonoTarjetaCredito;
import com.clinica.ClinicaMedica.model.Prestacion;
import com.clinica.ClinicaMedica.model.Receta;

@Repository
public interface AbonoTarjetaCreditoRepository extends JpaRepository<AbonoTarjetaCredito, Long>{

}
