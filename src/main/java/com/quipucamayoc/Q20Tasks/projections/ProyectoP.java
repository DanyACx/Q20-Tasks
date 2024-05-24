package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;

public interface ProyectoP {

	Integer getIdProyecto();
	
	String getNombProy();
	
	String getFechIniProy();
	
	String getFechRealCierreProy();
	
	String getCodigoProy();
	
	String getEstProy();
	
	String getSysFechRegistro();
	
	String getIdConvenio();
	
	Integer getIdCoordinador();
	
	String getNombEstProy();
	
	String getNombCoor();
	
	String getFechFinProy();
	
	String getMontoTotalProy();
	
	String getFormatoConv();
	
	Integer getIdUnidad();
	
	Integer getIdArea();
	
	String getNombUnidad();
	
	String getPropietarioConv();
	
	String getAreaDisplayName();
	
	String getAreaName();
	
	String getJustProy();
	
	String getClavesProy();
	
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
	
}
