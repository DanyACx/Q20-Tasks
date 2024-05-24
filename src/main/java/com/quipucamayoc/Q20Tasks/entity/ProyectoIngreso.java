package com.quipucamayoc.Q20Tasks.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "proyecto_ingreso", schema = "bytsscom_bytsig")
public class ProyectoIngreso {

	@EmbeddedId
	private ProyectoIngresoId proyectoIngresoId;
	
	@Column(name = "id_convenio")
	private String idConvenio;
	
	@Column(name = "fech_reg_ingreso")
	private Date fechRegIngreso;
	
	@Column(name = "fech_aut_ingreso")
	private Date fechAutIngreso;
	
	@Column(name = "id_moneda")
	private Integer idMoneda;
	
	@Column(name = "tipo_camb_ingreso")
	private BigDecimal tipoCambIngreso;
	
	@Column(name = "monto_ingreso")
	private BigDecimal montoIngreso;
	
	@Column(name = "estado_ingreso")
	private String estadoIngreso;
	
	@Column(name = "id_fuente")
	private Integer idFuente;
	
	@Column(name = "desc_ingreso")
	private String descIngreso;
	
	@Column(name = "nomb_proy")
	private String obsIngreso;
	
	@Column(name = "administrado_por")
	private String administradoPor;
	
	@Column(name = "fech_resol_ingreso")
	private Date fechResolIngreso;
	
	@Column(name = "num_resol_ingreso")
	private String numResolIngreso;
	
	@Column(name = "fech_recibo_ingreso")
	private Date fechReciboIngreso;
	
	@Column(name = "num_recibo_ingreso")
	private String numReciboIngreso;
	
	@Column(name = "id_fileheader")
	private Integer idFileheader;
	
	@Column(name = "isFirst")
	private Integer isFirst;
	
	@Column(name = "id_cuenta_banco")
	private Integer idCuentaBanco;
	
	@Column(name = "id_responsable")
	private Integer idResponsable;
	
	@Column(name = "id_user_regingreso")
	private Integer idUserRegingreso;
	
	@Column(name = "is_ingreso_base")
	private Integer isIngresoBase;
	
	@Column(name = "id_corr_ingreso_base")
	private Integer idCorrIngresoBase;
	
	@Column(name = "hito_ingreso")
	private Integer hitoIngreso;
	
	@Column(name = "tipo_ingreso")
	private String tipoIngreso;
	
	@Column(name = "num_transferencia")
	private String numTransferencia;
	
	@Column(name = "num_transferencia_display")
	private String numTransferenciaDisplay;
}
