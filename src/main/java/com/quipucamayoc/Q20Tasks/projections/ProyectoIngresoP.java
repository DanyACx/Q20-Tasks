package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface ProyectoIngresoP {

	Integer getIdProyecto();
	
	Integer getIdCorrIngreso();
	
	String getIdConvenio();
	
	Date getFechRegIngreso();
	
	Date getFechAutIngreso();
	
	Integer getIdMoneda();
	
	BigDecimal getTipoCambIngreso();
	
	BigDecimal getMontoIngreso();
	
	String getEstadoIngreso();
	
	Integer getIdFuente();
	
	String getDescIngreso();
	
	String getObsIngreso();
	
	String getAdministradoPor();
	
	Date getFechResolIngreso();
	
	String getNumResolIngreso();
	
	Date getFechReciboIngreso();
	
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
