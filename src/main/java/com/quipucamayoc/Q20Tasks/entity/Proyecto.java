package com.quipucamayoc.Q20Tasks.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "proyecto", schema = "bytsscom_bytsig")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proyecto")
	private Integer idProyecto;
	
	@Column(name = "nomb_proy")
	private String nombProy;
	
	@Column(name = "fech_ini_proy")
	private String fechIniProy;
	
	@Column(name = "durac_proy")
	private Integer duracProy;
	
	@Column(name = "tipo_proy")
	private String tipoProy;
	
	@Column(name = "id_area_prioritaria")
	private Integer idAreaPrioritaria;
	
	@Column(name = "claves_proy")
	private String clavesProy;
	
	@Column(name = "just_proy")
	private String justProy;
	
	@Column(name = "hipo_proy")
	private String hipoProy;
	
	@Column(name = "resul_espe_proy")
	private String resulEspeProy;
	
	@Column(name = "impacto_proy")
	private String impactoProy;
	
	@Column(name = "id_fileheader")
	private Integer idFileheader;
	
	@Column(name = "durac_real_proy")
	private Integer duracRealProy;
	
	@Column(name = "fech_real_cierre_proy")
	private String fechRealCierreProy;
	
	@Column(name = "nro_addendas")
	private Integer nroAddendas;
	
	@Column(name = "codigo_proy")
	private String codigoProy;
	
	@Column(name = "id_disciplinaocde")
	private Integer idDisciplinaocde;
	
	@Column(name = "est_proy")
	private String estProy;
	
	@Column(name = "sys_fech_registro")
	private LocalDate sysFechRegistro;
	
	@Column(name = "id_area_investigacion")
	private Integer idAreaInvestigacion;
	
	@Column(name = "id_linea_investigacion")
	private Integer idLineaInvestigacion;
	
	@Column(name = "obj_general_proy")
	private String objGeneralProy;
	
	@Column(name = "id_esquema_finan")
	private Integer idEsquemaFinan;
	
	@Column(name = "resumen_ejecutivo")
	private String resumenEjecutivo;
	
	@Column(name = "id_investigador")
	private Integer idInvestigador;
	
	@Column(name = "id_proyecto_tipo")
	private Integer idProyectoTipo;
	
	@Column(name = "id_proyecto_subtipo")
	private Integer idProyectoSubtipo;
	
	@Column(name = "path_video")
	private String pathVideo;
	
	@Column(name = "fech_real_inicio_proy")
	private String fechRealInicioProy;
	
	@Column(name = "id_tiposubvencionado")
	private String idTiposubvencionado;
	
	@Column(name = "result_concluye_rep_final")
	private String resultConcluyeRepFinal;
	
	@Column(name = "id_moneda_rend")
	private Integer idMonedaRend;
	
	@Column(name = "id_convenio")
	private String idConvenio;
	
	@Column(name = "id_proyecto_convenio")
	private String idProyectoConvenio;
	
	@Column(name = "import_fech_update")
	private String importFechUpdate;
	
	@Column(name = "id_coordinador")
	private Integer idCoordinador;
	
	@Column(name = "id_moneda")
	private Integer idMoneda;
	
	@Column(name = "monto_total_proy")
	private Integer montoTotalProy;
	
	@Column(name = "resolucion_proy")
	private String resolucionProy;
	
	@Column(name = "gestionado_por")
	private String gestionadoPor;
	
	@Column(name = "id_area")
	private Integer idArea;
	
	@Column(name = "id_unidad")
	private Integer idUnidad;
	
	@Column(name = "is_proy_old")
	private Integer isProyOld;
	
	@Column(name = "fech_fin_proy")
	private String fechFinProy;
}
