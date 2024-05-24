package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quipucamayoc.Q20Tasks.entity.TareaMeta;
import com.quipucamayoc.Q20Tasks.projections.TareaMetaP;

public interface TareaMetaRepository extends JpaRepository<TareaMeta, Integer>{

	@Query(value = "SELECT tm.id_tarea_meta AS idTareaMeta, "+
			"       tm.monto_prog AS montoProg, "+
			"       tm.id_fuente AS idFuente, "+
			"       tm.abre_fuente AS abreFuente, "+
			"       tm.id_meta_institucional AS idMetaInstitucional, "+
			"       tm.cod_met_ins AS codMetIns, "+
			"       tm.sec_func_siaf AS secFuncSiaf, "+
			"       Sum(CASE WHEN tm.id_fuente = 2 THEN tm.monto_prog ELSE 0 END) AS rdr, "+
			"       Sum(CASE WHEN tm.id_fuente = 14 THEN tm.monto_prog ELSE 0 END) AS ra, "+
			"       Sum(CASE WHEN tm.id_fuente = 15 THEN tm.monto_prog ELSE 0 END) AS r18, "+
			"       Sum(CASE WHEN tm.id_fuente = 4 THEN tm.monto_prog ELSE 0 END) AS rnp, "+
			"       tm.nomb_met_ins AS nombMetIns, "+
			"       tm.id_anio_item as idAnio "+
			"  FROM bytsscom_bytsig.vw_tarea_meta tm "+
			" WHERE tm.orig_tipo = 'PROYECTO' "+
			"       AND tm.orig_pk = :idproyecto "+
			"GROUP BY tm.id_tarea_meta, "+
			"       tm.monto_prog, "+
			"       tm.id_fuente, "+
			"       tm.abre_fuente, "+
			"       tm.id_meta_institucional, "+
			"       tm.cod_met_ins, "+
			"       tm.sec_func_siaf, "+
			"       tm.nomb_met_ins, "+
			"       tm.id_anio_item ", nativeQuery = true)
	List<TareaMetaP> getMetasPresupuestales(@Param("idproyecto") Integer idproyecto);
}
