package com.quipucamayoc.Q20Tasks.entity;

import java.math.BigDecimal;

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
@Table(name = "bytsscom_bytsig", schema = "bytsscom_bytsig")
public class ProyectoEquipo {

	@EmbeddedId
	private ProyectoEquipoId proyectoEquipoId;
	
	@Column(name = "full_name_per")
	private String fullNamePer;
	
	@Column(name = "cargo_equipo")
	private String cargoEquipo;
	
	@Column(name = "prof_equipo")
	private String profEquipo;
	
	@Column(name = "id_corr_asociada")
	private Integer idCorrAsociada;
	
	@Column(name = "id_persona")
	private Integer idPersona;
	
	@Column(name = "id_cargo_equipo")
	private Integer idCargoEquipo;
	
	@Column(name = "id_prof_equipo")
	private Integer idProfEquipo;
	
	@Column(name = "porcentaje_participacion")
	private Integer porcentajeParticipacion;
	
	@Column(name = "id_integrante")
	private Integer idIntegrante;
	
	@Column(name = "tiene_rel_contrac")
	private String tieneRelContrac;
	
	@Column(name = "id_fileheader")
	private Integer idFileheader;
	
	@Column(name = "estado_equipo")
	private String estadoEquipo;
	
	@Column(name = "motivo_baja_equipo")
	private String motivoBajaEquipo;
	
	@Column(name = "monto_subvencion")
	private BigDecimal montoSubvencion;
}
