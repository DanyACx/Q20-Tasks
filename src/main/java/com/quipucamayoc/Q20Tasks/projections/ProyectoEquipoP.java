package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;

public interface ProyectoEquipoP {

	Integer getIdProyecto();
	
	Integer getIdCorrEquipo();
	
	String getFullNamePer();
	
	String getCargoEquipo();
	
	String getProfEquipo();
	
	Integer getIdCorrAsociada();
	
	Integer getIdPersona();
	
	Integer getIdCargoEquipo();
	
	Integer getIdProfEquipo();
	
	Integer getPorcentajeParticipacion();
	
	Integer getIdIntegrante();
	
	String getTieneRelContrac();
	
	Integer getIdFileheader();
	
	String getEstadoEquipo();
	
	String getMotivoBajaEquipo();
	
	BigDecimal getMontoSubvencion();
	
	String getFullnamePerIntegrante();
	
	String getAreaDisplayNameIntegrante();
	
	String getDesccargo();
}
