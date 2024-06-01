package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface ProyectoIngresoP {

	Integer getIdProyecto();
	
	Integer getIdCorrIngreso();
	
	String getIdConvenio();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechRegIngreso();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechAutIngreso();
	
	Integer getIdMoneda();
	
	BigDecimal getTipoCambIngreso();
	
	BigDecimal getMontoIngreso();
	
	String getEstadoIngreso();
	
	Integer getIdFuente();
	
	String getDescIngreso();
	
	String getObsIngreso();
	
	String getAdministradoPor();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechResolIngreso();
	
	String getNumResolIngreso();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechReciboIngreso();
	
	String getNumReciboIngreso();
	
	Integer getIdFileheader();
	
	Integer getIsFirst();
	
	Integer getIdCuentaBanco();
	
	Integer getIdResponsable();
	
	Integer getIdUserRegingreso();
	
	Integer getIsIngresoBase();
	
	Integer getIdCorrIngresoBase();
	
	Integer getHitoIngreso();
	
	String getTipoIngreso();
	
	String getNumTransferencia();
	
	String getNumTransferenciaTisplay();
}
