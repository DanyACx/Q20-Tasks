package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quipucamayoc.Q20Tasks.entity.ProyectoActividad;
import com.quipucamayoc.Q20Tasks.entity.ProyectoActividadId;
import com.quipucamayoc.Q20Tasks.projections.ProyectoActividadP;

public interface ProyectoActividadRepository extends JpaRepository<ProyectoActividad, ProyectoActividadId>{

	@Query(value = "SELECT id_proyecto AS idProyecto, id_corr_actividad AS idCorrActividad, id_corr_componente AS idCorrComponente," +
			" desc_actividad AS descActividad, meta_actividad AS metaActividad, ini_actividad AS iniActividad, fin_actividad AS finActividad"+
			" FROM bytsscom_bytsig.proyecto_actividad "+
			" WHERE id_proyecto = :idproyecto "+
			" ORDER BY id_corr_actividad", nativeQuery = true)
	List<ProyectoActividadP> getActividades(@Param("idproyecto") Integer idproyecto);
}
