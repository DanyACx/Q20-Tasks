package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface RequerimientoP {
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate getFechSolRequ();

	String getNumMemoRequ();

	String getAsuntoRequ();

	String getSolicitante();

	String getAreasol();

	String getNombEstaRequ();

	BigDecimal getMontEstaRequ();

	String getNumExpediente();

}
