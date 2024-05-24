package com.quipucamayoc.Q20Tasks.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProyectoIngresoId implements Serializable{

	@Column(name = "id_proyecto")
	private Integer idProyecto;
	
	@Column(name = "id_corr_ingreso")
	private Integer idCorrIngreso;
}
