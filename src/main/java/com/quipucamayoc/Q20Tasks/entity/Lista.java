package com.quipucamayoc.Q20Tasks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "lista", schema = "bytsscom_bytcore")
public class Lista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
	private Integer idLista;

	@Column(name = "entidad", length = 30)
	private String entidad;

	@Column(name = "cod_lista", length = 30)
	private String codLista;

	@Column(name = "desc_lista", length = 300)
	private String descLista;

	@Column(name = "estado_lista")
	private Integer estadoLista;

	@Column(name = "cod_siaf", length = 10)
	private String codSiaf;

	@Column(name = "orden_lista")
	private Integer ordenLista;

	@Column(name = "tag_lista", length = 100)
	private String tagLista;

	@Column(name = "cod_concytec", length = 1)
	private Character codConcytec;

	@Column(name = "cred_fiscal", length = 5)
	private String credFiscal;

}
