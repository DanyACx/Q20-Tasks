package com.quipucamayoc.Q20Tasks.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProyectoActividadId implements Serializable{

	@Column(name = "id_proyecto")
	private Integer idProyecto;
	
	@Column(name = "id_corr_actividad")
	private Integer idCorrActividad;
}
