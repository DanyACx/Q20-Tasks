package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quipucamayoc.Q20Tasks.entity.ProyectoEquipo;
import com.quipucamayoc.Q20Tasks.entity.ProyectoEquipoId;
import com.quipucamayoc.Q20Tasks.projections.ProyectoEquipoP;

public interface ProyectoEquipoRepository extends JpaRepository<ProyectoEquipo, ProyectoEquipoId>{

	@Query(value = "SELECT pe.id_proyecto AS idProyecto, "+
			"       pe.id_corr_equipo AS idCorrEquipo, "+
			"       pe.full_name_per AS fullNamePer, "+
			"       pe.cargo_equipo AS cargoEquipo, "+
			"       pe.prof_equipo AS profEquipo, "+
			"       pe.id_corr_asociada AS idCorrAsociada, "+
			"       pe.id_persona AS idPersona, "+
			"       pe.id_cargo_equipo AS idCargoEquipo, "+
			"       pe.id_prof_equipo AS idProfEquipo, "+
			"       pe.porcentaje_participacion AS porcentajeParfticipacion, "+
			"       pe.id_integrante AS idIntegrante, "+
			"       pe.tiene_rel_contrac AS tieneRelContrac, "+
			"       pe.id_fileheader AS idFileheader, "+
			"       pe.estado_equipo AS estadoEquipo, "+
			"       pe.motivo_baja_equipo AS motivoBajaEquipo, "+
			"       pe.monto_subvencion AS montoSubvencion, "+
			"       pers.full_name_per AS fullNamePerIntegrante, "+
			"       pers.area_display_name AS areaDisplayNameIntegrante, "+
			"       li.desc_lista AS desccargo "+
			"FROM bytsscom_bytsig.proyecto_equipo pe "+
			"INNER JOIN bytsscom_bytcore.vw_personal pers ON pers.id_persona = pe.id_persona "+
			"LEFT JOIN bytsscom_bytcore.lista li ON li.id_lista = pe.id_cargo_equipo "+
			"AND li.entidad = 'PROYECTO-EQUIPO-CARGO' "+
			"WHERE pe.id_proyecto = :idproyecto ORDER BY pe.id_corr_equipo", nativeQuery = true)
	List<ProyectoEquipoP> getEquipo(@Param("idproyecto") Integer idproyecto);
}
