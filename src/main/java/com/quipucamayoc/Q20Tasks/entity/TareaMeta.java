package com.quipucamayoc.Q20Tasks.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
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
@Table(name = "tarea_meta", schema = "bytsscom_bytsig")
public class TareaMeta {

	@Column(name = "id_tarea_meta")
	private Integer idTareaMeta;
	
	@Column(name = "desc_item")
	private String descItem;
	
	@Column(name = "activo_pprog")
	private Integer activoPprog;
	
	@Column(name = "monto_pprog")
	private BigDecimal montoPprog;
	
	@Column(name = "meta_pprog")
	private BigDecimal metaPPprog;
	
	@Column(name = "id_fuente")
	private Integer idFuente;
	
	@Column(name = "id_meta_institucional")
	private Integer idMetaInstitucional;
	
	@Column(name = "id_ambito")
	private Integer idAmbito;
	
	@Column(name = "id_item")
	private Integer idItem;
	
	@Column(name = "cod_item")
	private String codItem;
	
	@Column(name = "orig_tipo")
	private String origTipo;
	
	@Column(name = "orig_pk")
	private Integer origPk;
	
	@Column(name = "id_area")
	private Integer idArea;
	
	@Column(name = "id_unidad")
	private Integer idUnidad;
	
	@Column(name = "id_cn")
	private Integer idCn;
	
	@Column(name = "id_plan")
	private Integer idPlan;
	
	@Column(name = "fts_tarea", columnDefinition = "tsvector")
	private String ftsTarea;
	
	@Column(name = "id_anio_item")
	private Integer idAnioItem;
}
