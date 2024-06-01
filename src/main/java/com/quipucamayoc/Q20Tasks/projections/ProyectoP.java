package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface ProyectoP {

	Integer getIdProyecto();
	
	String getNombProy();
	
	String getFechIniProy();
	
	String getFechRealCierreProy();
	
	String getCodigoProy();
	
	String getEstProy();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechaRegistro();
	
	String getIdConvenio();
	
	Integer getIdCoordinador();
	
	String getNombEstProy();
	
	String getNombCoor();
	
	String getFechFinProy();
	
	BigDecimal getMontoTotalProy();
	
	String getFormatoConv();
	
	Integer getIdUnidad();
	
	Integer getIdArea();
	
	String getNombUnidad();
	
	String getPropietarioConv();
	
	String getAreaDisplayName();
	
	String getAreaName();
	
	String getJustProy();
	
	String getClavesProy();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	String getImportFechUpdate();
	
	String getDescPpto();
	
	Integer getIdClasificador();
	
	String getCodClasif();
	
	String getTipoPpto();
	
	Integer getIdCorrPpto();
	
	BigDecimal getRdr();
	
	BigDecimal getRa();
	
	BigDecimal getR18();
	
	BigDecimal getRnp();
	
	BigDecimal getMontoPpto();
	
	Integer getIdAnio();
	
	String getNameCoordinador();
	
	String getCodUnidadCoordinadorProy();
	
	String getNombUnidadCoordinadorProy();
	
	Integer getIdUnidadCoordinador();
	
	Integer getIdAreaCoordinador();
	
	String getEmailCoordinador();
	
	String getCodUnidadCoordinador();
	
	String getNombUnidadCoordinador();
	
	String getTipoProyecto();
	
}
