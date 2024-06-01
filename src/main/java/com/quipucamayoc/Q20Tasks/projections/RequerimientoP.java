package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface RequerimientoP {
	
	Integer getIdMemoRequerimientro();
	
	Integer getIdArea();
	
	Integer getIdUserRegRequ();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechSolRequ();
	
	String getAsuntoRequ();
	
	String getEstaRequ();
	
	Integer getIdAnio();
	
	String getNumMemoRequ();

	Integer getIdUserSolRequ();
	
	String getIdMemoTipo();
	
	String getTipoMemo();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getSysFechRegistro();

	Integer getIdproyecto();
	
	Integer getIdFuente();
	
	String getOrigenReq();
	
	String getNombEstaRequ();
	
	String getAbreFuente();
	
	BigDecimal getMontsolReq();
	
	String getSolicitante();

	String getAreasol();

	BigDecimal getMontEstaRequ();

	String getNumExpediente();

}
