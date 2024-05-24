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
@Table(name = "proyecto_actividad", schema = "bytsscom_bytsig")
public class ProyectoActividad {

	@EmbeddedId
	private ProyectoActividadId proyectoActividadId;
	
	@Column(name = "desc_actividad")
	private String descActividad;
	
	@Column(name = "meta_actividad")
	private BigDecimal metaActividad;
	
	//private Integer idCorrActividad;
	
	@Column(name = "nomb_unimed")
	private String nombUnimed;
	
	//private Integer idProyecto;
	
	@Column(name = "id_corr_componente")
	private Integer idCorrComponente;
	
	@Column(name = "ini_actividad")
	private Date iniActividad;
	
	@Column(name = "fin_actividad")
	private Date finActividad;
	
	@Column(name = "id_actividad_convenio")
	private String idActividadConvenio;
}
