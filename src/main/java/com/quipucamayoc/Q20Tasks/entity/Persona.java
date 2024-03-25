package com.quipucamayoc.Q20Tasks.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "persona", schema = "bytsscom_bytcore")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;

	@Column(name = "tipo_per", nullable = false)
	private Character tipoPer;

	@OneToOne
	@JoinColumn(name = "tipo_doc_per", referencedColumnName = "id_lista")
	private Lista lista;

	@Column(name = "nro_doc_per", length = 20)
	private String nroDocPer;

	@Column(name = "ape_pat_per", length = 100)
	private String apePatPer;

	@Column(name = "ape_mat_per", length = 100)
	private String apeMatPer;

	@Column(name = "nomb_per", length = 200)
	private String nombPer;

	@Column(name = "direc_per", length = 500)
	private String direcPer;

	@Column(name = "sex_per", length = 1)
	private Character sexPer;

	@Column(name = "fech_nac_per")
	private Date fechNacPer;

	@Column(name = "id_pais_nac")
	private Integer idPaisNac;

	@Column(name = "aud_fech_crea", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date audFechCrea;

	@Column(name = "est_civil_per", length = 1)
	private Character estCivilPer;

	@Column(name = "id_ubigeo_nac")
	private Integer idUbigeoNac;

	@Column(name = "siaf_sec_ejec", length = 6)
	private String siafSecEjec;

	@Column(name = "nro_ruc", length = 11)
	private String nroRuc;

	@Column(name = "id_ubigeo_dir")
	private Integer idUbigeoDir;

	@OneToOne
	@JoinColumn(name = "id_fileheader", referencedColumnName = "id_fileheader")
	private FileHeader idFileHeader;

	@Column(name = "id_investigador")
	private Integer idInvestigador;

	@Column(name = "fts_persona", columnDefinition = "tsvector")
	private String ftsPersona;

	@Column(name = "fg_domiciliado", length = 1)
	private Character fgDomiciliado;

	@Column(name = "prefijo_per", length = 20)
	private String prefijoPer;

	@Column(name = "siaf_sec_ejec_r", length = 6)
	private String siafSecEjecR;

	@Column(name = "siaf_tipo_id", length = 1)
	private Character siafTipoId;

}
