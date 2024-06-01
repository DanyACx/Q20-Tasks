package com.quipucamayoc.Q20Tasks.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProyectoEjecucion {

	@Id
	private Integer idMemoRequerimiento;
	
	private String numMemoReque;
	
	private String idMemoTipo;
	
	private String descRequ;
	
	private Integer idFuente;
	
	private String siafTipoFinan;
	
	private String numTransferencia;
	
	private String siaf;
	
	private BigDecimal montsolreq;
	
	private BigDecimal montoCerti;
	
	private BigDecimal montoCanual;
	
	private BigDecimal montoCompromiso;
	
	private BigDecimal montoDeven;
	
	private BigDecimal montoGiro;
	
	private BigDecimal total;
	
}
