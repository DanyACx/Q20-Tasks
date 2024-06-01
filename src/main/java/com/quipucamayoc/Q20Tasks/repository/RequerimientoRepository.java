package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quipucamayoc.Q20Tasks.entity.Requerimiento;
import com.quipucamayoc.Q20Tasks.projections.RequerimientoP;

@Repository
public interface RequerimientoRepository extends JpaRepository<Requerimiento, Integer>{

	@Query(value = "SELECT "+
			"               mr.fech_sol_requ 											AS fechSolRequ, "+
			"               mr.num_memo_requ 											AS numMemoRequ, "+
			"               mr.asunto_requ 												AS asuntoRequ, "+
			"               pe.full_name_per                                            AS solicitante, "+
			"               a.area_display_name                                         AS areasol, "+
			"               CASE mr.esta_requ "+
			"                 WHEN '2' THEN 'Rechazado' "+
			"                 WHEN 'X' THEN 'Anulado' "+
			"                 ELSE "+
			"                   CASE coalesce(mr.id_responsable, 0) "+
			"                     WHEN 0 THEN 'Registrado' "+
			"                     ELSE "+
			"                       CASE coalesce(aten.id_memo_requerimiento, 0) "+
			"                         WHEN 0 THEN 'En ejecución' "+
			"                         ELSE 'Atendido' "+
			"                       END "+
			"                   END "+
			"               END                                                          AS nombEstaRequ, "+
			"               (SELECT SUM (mi.mont_total_item) "+
			"                  FROM bytsscom_bytsig.memo_requerimiento_item mi "+
			"                 WHERE mi.id_memo_requerimiento = mr.id_memo_requerimiento AND mi.estado_memo_item = 'A') AS montEstaRequ, "+
			"               ex.num_expediente                                            AS NumExpediente "+
			"      FROM bytsscom_bytsig.memo_requerimiento mr "+
			"           INNER JOIN bytsscom_bytcore.vw_persona pe "+
			"                   ON mr.id_user_solrequ = pe.id_persona "+
			"           LEFT JOIN bytsscom_bytsig.vw_requerimiento_atendido aten "+
			"                  ON mr.id_memo_requerimiento = aten.id_memo_requerimiento "+
			"           LEFT JOIN bytsscom_bytcore.area a "+
			"                  ON mr.id_area = a.id_area "+
			"           LEFT JOIN bytsscom_bytsig.expediente ex "+
			"                  ON mr.id_memo_requerimiento = ex.id_referencia "+
			"                     AND ex.tipo_expediente = 'REQUERIMIENTO' "+
			"           LEFT JOIN bytsscom_bytsig.proyecto pr "+
			"                  ON mr.id_proyecto = pr.id_proyecto "+
			"           LEFT JOIN (SELECT mri.id_memo_requerimiento, "+
			"                             max (ri.id_reg_adquisicion) AS id_reg_adquisicion "+
			"                        FROM bytsscom_bytsig.reg_adquisicion_item ri "+
			"                             inner join bytsscom_bytsig.reg_adquisicion ra "+
			"                                     ON ri.id_reg_adquisicion = ra.id_reg_adquisicion "+
			"                             INNER JOIN bytsscom_bytsig.memo_requerimiento_item mri "+
			"                                     ON ri.id_memo_item = mri.id_memo_item "+
			"                       WHERE ra.esta_reg_adq != 3 "+
			"                       GROUP BY mri.id_memo_requerimiento) tbl "+
			"                  ON mr.id_memo_requerimiento = tbl.id_memo_requerimiento "+
			"        where "+
			"            mr.id_memo_tipo = 'REQ' "+
			"                AND (:idanio IS NULL OR mr.id_anio = :idanio ) "+
			"                AND (:fechsolrequ IS NULL OR date_part('month',mr.fech_sol_requ) = :fechsolrequ ) "+
			"                AND (:idunidad IS NULL OR mr.id_unidad = :idunidad ) "+
			"                AND (:areatipo IS NULL OR substring(a.area_name,1,1) = :areatipo ) "+  // substring(a.area_name,1,1) = :areatipo
			"                AND (:idfuente IS NULL OR mr.id_fuente = :idfuente ) "+
			"          ORDER BY "+
			"            ex.num_expediente desc, mr.num_memo_requ desc ", nativeQuery = true)
	List<RequerimientoP> getListRequerimientos(@Param("idanio") Integer idanio, @Param("fechsolrequ") Integer fechsolrequ, @Param("idunidad") Integer idunidad, @Param("areatipo") String areatipo, @Param("idfuente") Integer idfuente);
	
	@Query(value = "SELECT "+
			"          mr.id_memo_requerimiento AS idMemoRequerimiento, "+
			"      mr.id_area AS idArea, "+
			"      mr.id_user_reg_requ AS idUserRegRequ, "+
			"      mr.fech_sol_requ AS fechSolRequ, "+
			"      mr.asunto_requ AS asuntoRequ, "+
			"      mr.esta_requ AS estaRequ, "+
			"      mr.id_anio AS idAnio, "+
			"      mr.num_memo_requ AS numMemoRequ, "+
			"      mr.id_user_solrequ AS idUserSolRequ, "+
			"      mr.id_memo_tipo AS idMemoTipo, "+
			"      mr.tipo_memo AS tipoMemo, "+
			"      mr.sys_fech_registro AS sysFechRegistro, "+
			"      mr.id_proyecto AS idProyecto, "+
			"          mr.id_fuente AS idFuente, "+
			"          mr.origen_req AS origenReq, "+
			"          mr.origen_id AS origenId, "+
			"          mr.nomb_esta_requ AS nombEstaRequ, "+
			"          mr.abre_fuente AS abreFuente, "+
			"          mri.montsolreq AS montsolreq "+
			"FROM      bytsscom_bytsig.vw_memo_requerimiento mr "+
			//"LEFT JOIN bytsscom_bytcore.bpm_task bpm "+
			//"ON        bpm.process_key ='proyecto_req' "+
			//"AND       bpm.business_key = mr.id_memo_requerimiento::text "+
			"LEFT JOIN "+
			"          ( "+
			"                   SELECT   mri.id_memo_requerimiento, "+
			"                            SUM(mri.mont_total_item) AS montsolreq "+
			"                   FROM     bytsscom_bytsig.memo_requerimiento_item mri "+
			"                   GROUP BY mri.id_memo_requerimiento ) mri "+
			"ON        mri.id_memo_requerimiento = mr.id_memo_requerimiento "+
			"WHERE     mr.id_proyecto = :idproyecto "+
			"AND       mr.origen_req = 'PROYECTO' "+
			"AND       mr.esta_requ != 'X' "+
			"ORDER BY  mr.fech_sol_requ DESC ", nativeQuery = true)
	List<RequerimientoP> getRequerimientoProyecto(@Param("idproyecto") Integer idproyecto);
}
