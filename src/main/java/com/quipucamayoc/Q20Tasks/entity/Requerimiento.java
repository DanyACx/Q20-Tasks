package com.quipucamayoc.Q20Tasks.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "memo_requerimiento", schema = "bytsscom_bytsig")
public class Requerimiento {

	@Id
	@Column(name = "id_memo_requerimiento")
	private Integer idMemoRequerimiento;
	
	@Column(name = "id_area")
	private Integer idArea;
	
	@Column(name = "id_user_reg_requ")
	private Integer idUserRegRequ;
	
	@Column(name = "fech_sol_requ")
	private Date fechSolrequ;
	
	@Column(name = "ref_requ")
	private String refRequ;
	
	@Column(name = "asunto_requ")
	private String asuntoRequ;
	
	@Column(name = "esta_requ")
	private String estaRequ;
	
	@Column(name = "id_anio")
	private Integer idAnio;
	
	@Column(name = "num_memo_requ")
	private String numMemoRequ;
	
	@Column(name = "no_objecion_requ")
	private String noObjecionRequ;
	
	@Column(name = "docu_adju_requ")
	private String docuAdjuRequ;
	
	@Column(name = "desc_requ")
	private String descRequ;
	
	@Column(name = "aud_fech_crea")
	private Date audFechCrea;
	
	@Column(name = "obs_requ")
	private String obsRequ;
	
	@Column(name = "id_user_solrequ")
	private Integer idUserSolrequ;
	
	@Column(name = "id_memo_tipo")
	private String idMemoTipo;
	
	@Column(name = "desc_aprob")
	private String descAprob;
	
	@Column(name = "id_user_boss")
	private Integer idUserBoss;
	
	@Column(name = "alm_atender")
	private String almAtender;
	
	@Column(name = "gen_ped_alm")
	private String genPedAlm;
	
	@Column(name = "id_tdr")
	private Integer idTdr;
	
	@Column(name = "id_fileheader")
	private Integer idFileheader;
	
	@Column(name = "tipo_memo")
	private String tipoMemo;
	
	@Column(name = "fech_asig_resp")
	private Date fechAsigResp;
	
	@Column(name = "id_responsable")
	private Integer idResponsable;
	
	@Column(name = "fech_not_resp")
	private Date fechNotResp;
	
	@Column(name = "sys_fech_registro")
	private Date sysFechRegistro;
	
	@Column(name = "id_proyecto")
	private Integer idProyecto;
	
	@Column(name = "id_ame")
	private Integer idAme;
	
	@Column(name = "id_referencia")
	private Integer idReferencia;
	
	@Column(name = "id_expediente")
	private Integer idExpediente;
	
	@Column(name = "id_fuente")
	private Integer idFuente;
	
	@Column(name = "origen_req")
	private String origenReq;
	
	@Column(name = "origen_id")
	private Integer origenId;
	
	@Column(name = "id_unidad")
	private Integer idUnidad;
	
	@Column(name = "id_responsable_alm")
	private Integer idResponsableAlm;
	
	@Column(name = "fech_asig_resp_alm")
	private Date fechAsigRespAlm;
	
	@Column(name = "id_caja_chica")
	private Integer idCajaChica;
	
	@Column(name = "id_certificado")
	private Integer idCertificado;
	
	@Column(name = "id_compromiso_anual")
	private Integer idCompromisoAnual;
	
	@Column(name = "motivo_anula")
	private String motivoAnula;
	
	@Column(name = "is_recon_deuda")
	private String isReconDeuda;
	
	@Column(name = "id_user_amerequ")
	private Integer idUserAmerequ;
	
	@Column(name = "siaf_ps_ejec")
	private String siafPsEjec;
	
	@Column(name = "siaf_ps_id_proc")
	private String siafPsIdProc;
	
	@Column(name = "siaf_ps_id_cont")
	private String siafPsIdCont;
	
	@Column(name = "siaf_ps_tipo_proc")
	private String siafPsTipoProc;
	
	@Column(name = "id_proveedor")
	private Integer idProveedor;
	
	@Column(name = "id_unidad_compra")
	private String idUnidadCompra;
	
	@Column(name = "is_rpg_ok")
	private String isRpgOk;
	
	@Column(name = "num_transferencia")
	private String numTransferencia;
	
	@Column(name = "siaf_tipo_finan")
	private String siafTipoFinan;
	
	@Column(name = "fecha_rpg_alm")
	private Date fechaRpgAlm;
	
	@Column(name = "num_inf_aten_requ")
	private String numInfAtenRequ;
	
	@Column(name = "id_pac_cn")
	private Integer idPacCn;
	
	@Column(name = "id_tipo_proceso_cont")
	private Integer idTipoProcesoCont;
	
	@Column(name = "id_contrato_ref")
	private Integer idContratoRef;
	
	@Column(name = "num_proc_sel")
	private String numProcSel;
	
	@Column(name = "is_prevision_presupuestal")
	private String isPrevisionPresupuestal;
	
	@Column(name = "id_tipo_certi")
	private Integer idTipoCerti;

}
