package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;

public interface ProyectoEjecucionP {

	Integer getIdMemoRequerimiento();
	
	String getNumMemoReque();
	
	String getIdMemoTipo();
	
	String getDescRequ();
	
	Integer getIdFuente();
	
	String getSiafTipoFinan();
	
	String getNumTransferencia();
	
	String getSiaf();
	
	BigDecimal getMontsolreq();
	
	BigDecimal getMontoCerti();
	
	BigDecimal getMontoCanual();
	
	BigDecimal getMontoCompromiso();
	
	BigDecimal getMontoDeven();
	
	BigDecimal getMontoGiro();
	
	BigDecimal getTotal();
}
