package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quipucamayoc.Q20Tasks.entity.ProyectoEjecucion;
import com.quipucamayoc.Q20Tasks.projections.ProyectoEjecucionP;

public interface ProyectoEjecucionRepository extends JpaRepository<ProyectoEjecucion, Integer>{

	@Query(value = "SELECT mr.id_memo_requerimiento AS idMemoRequerimiento, "+
			"       mr.id_anio "+
			"       || ' - ' "+
			"       || mr.num_memo_requ                     AS numMemoRequ, "+
			"       mt.id_memo_tipo AS idMemoTipo, "+
			"       meta_req.meta                           AS descRequ, "+
			"       f.id_fuente AS idFuente, "+
			"        case "+
			"        when mt.id_memo_tipo = 'PRENC' THEN (SELECT siaf_tipo_finan from bytsscom_bytsig.ame "+
			"        WHERE id_memo_requerimiento = mr.id_memo_requerimiento) "+
			"        ELSE    mr.siaf_tipo_finan "+
			"        END AS siafTipoFinan, "+
			"       mrtrans.num_transferencia AS numTransferencia, "+
			"       compromiso.siaf                         AS siaf, "+
			"       tablaReq.montoreq                       AS montsolreq, "+
			"       ccp.monto_certi                         AS montoCerti, "+
			"       ca.monto_ca                             AS montoCanual, "+
			"       compromiso.monto_comp                   AS montoCompromiso, "+
			"       devengado.monto_dev                     AS montoDeven, "+
			"       giro.monto_giro                         AS montoGiro, "+
			"       ( tablaReq.montoreq - giro.monto_giro ) AS total "+
			"  FROM bytsscom_bytsig.memo_requerimiento mr "+
			"       LEFT JOIN (SELECT mr.id_memo_requerimiento, "+
			"                         ( ori.ano_transferencia "+
			"                           || '-' "+
			"                           || ori.sec_ejec_origen "+
			"                           || '-' "+
			"                           || ori.transferencia "+
			"                           || '-' "+
			"                           || ori.secuencia_transferencia ) AS num_transferencia "+
			"                    FROM bytsscom_bytsig.memo_requerimiento mr "+
			"                         LEFT JOIN bytsscom_bytsig.ame am "+
			"                                ON mr.id_memo_requerimiento = am.id_ame "+
			"                         LEFT JOIN bytsscom_bytsiaf.transferencia_origen ori "+
			"                                ON ori.transferencia_financiera_id = "+
			"                                   lpad(COALESCE(mr.num_transferencia, am.num_transferencia), 10, '0') "+
			"                   WHERE mr.esta_requ <> 'X') mrtrans "+
			"              ON mr.id_memo_requerimiento = mrtrans.id_memo_requerimiento "+
			"       INNER JOIN bytsscom_bytsig.memo_tipo mt "+
			"               ON mr.id_memo_tipo = mt.id_memo_tipo "+
			"       INNER JOIN bytsscom_bytcore.fuente f "+
			"               ON mr.id_fuente = f.id_fuente "+
			"       LEFT JOIN (SELECT mr.id_memo_requerimiento, "+
			"                         Sum(mri.mont_total_item) AS montoreq "+
			"                    FROM bytsscom_bytsig.memo_requerimiento mr "+
			"                         INNER JOIN bytsscom_bytsig.memo_requerimiento_item mri "+
			"                                 ON mri.id_memo_requerimiento = mr.id_memo_requerimiento "+
			"                                    AND mri.estado_memo_item <> 'X' "+
			"                   WHERE mr.esta_requ <> 'X' "+
			"                   GROUP BY 1) tablaReq "+
			"              ON mr.id_memo_requerimiento = tablaReq.id_memo_requerimiento "+
			"       LEFT JOIN (SELECT mr.id_memo_requerimiento, "+
			"                         string_agg(DISTINCT ms.sec_func, ',') AS meta "+
			"                    FROM bytsscom_bytsig.memo_requerimiento mr "+
			"                         INNER JOIN bytsscom_bytsig.memo_requerimiento_item mri "+
			"                                 ON mri.id_memo_requerimiento = mr.id_memo_requerimiento "+
			"                                    AND mri.estado_memo_item <> 'X' "+
			"                         INNER JOIN bytsscom_bytsig.memo_requerimiento_meta mm "+
			"                                 ON mm.id_memo_item = mri.id_memo_item "+
			"                         INNER JOIN bytsscom_bytsig.tarea_meta tm "+
			"                                 ON mm.id_tarea_meta = tm.id_tarea_meta "+
			"                         INNER JOIN bytsscom_bytcore.meta_institucional_siaf ms "+
			"                                 ON tm.id_meta_institucional = ms.id_meta_institucional "+
			"                                    AND ms.id_anio = mr.id_anio "+
			"                   WHERE mr.esta_requ <> 'X' "+
			"                   GROUP BY 1) meta_req "+
			"              ON mr.id_memo_requerimiento = meta_req.id_memo_requerimiento "+
			"       LEFT JOIN (SELECT mr.id_memo_requerimiento, "+
			"                         COALESCE(Sum(cm.mont_meta_nac), 0) AS monto_certi "+
			"                    FROM bytsscom_bytsig.memo_requerimiento mr "+
			"                         LEFT JOIN bytsscom_bytsig.certificacion cert "+
			"                                ON mr.id_memo_requerimiento = cert.id_memo_requerimiento "+
			"                         JOIN bytsscom_bytsig.certificacion_sec cs "+
			"                           ON cert.id_certificacion = cs.id_certificacion "+
			"                         JOIN bytsscom_bytsig.certificacion_meta cm "+
			"                           ON cm.id_certificacion = cs.id_certificacion "+
			"                              AND cm.id_certificacion_sec = cs.id_certificacion_sec "+
			"                   WHERE COALESCE(cs.estado_sec, 'N') != 'X' "+
			"                         AND cert.esta_cert = 'A' "+
			"                         AND cert.tipo_cert = 'DP' "+
			"                         AND mr.esta_requ <> 'X' "+
			"                   GROUP BY 1) ccp "+
			"              ON mr.id_memo_requerimiento = ccp.id_memo_requerimiento "+
			"       LEFT JOIN (SELECT mr.id_memo_requerimiento, "+
			"                         COALESCE(Sum(cm.mont_meta_nac), 0) AS monto_ca "+
			"                    FROM bytsscom_bytsig.memo_requerimiento mr "+
			"                         LEFT JOIN bytsscom_bytsig.certificacion cert "+
			"                                ON mr.id_memo_requerimiento = cert.id_memo_requerimiento "+
			"                         JOIN bytsscom_bytsig.certificacion_sec cs "+
			"                           ON cert.id_certificacion = cs.id_certificacion "+
			"                         JOIN bytsscom_bytsig.certificacion_meta cm "+
			"                           ON cm.id_certificacion = cs.id_certificacion "+
			"                              AND cm.id_certificacion_sec = cs.id_certificacion_sec "+
			"                   WHERE COALESCE(cs.estado_sec, 'N') != 'X' "+
			"                         AND cert.esta_cert = 'A' "+
			"                         AND cert.tipo_cert = 'CA' "+
			"                         AND mr.esta_requ <> 'X' "+
			"                   GROUP BY 1) ca "+
			"              ON mr.id_memo_requerimiento = ca.id_memo_requerimiento "+
			"       LEFT JOIN (SELECT r.id_memo_requerimiento, "+
			"                         string_agg(DISTINCT r.siaf_expediente, ',') AS siaf, "+
			"                         COALESCE(Sum(rm1.monto_soles), 0)           AS monto_comp "+
			"                    FROM bytsscom_bytsig.registro_sec rs1 "+
			"                         JOIN bytsscom_bytsig.registro_meta rm1 "+
			"                           ON rm1.id_registro = rs1.id_registro "+
			"                              AND rm1.id_corr_fase = rs1.id_corr_fase "+
			"                              AND rm1.id_corr_sec = rs1.id_corr_sec "+
			"                         JOIN bytsscom_bytsig.registro_fase rf "+
			"                           ON rs1.id_registro = rf.id_registro "+
			"                              AND rs1.id_corr_fase = rf.id_corr_fase "+
			"                         JOIN bytsscom_bytsig.registro r "+
			"                           ON rf.id_registro = r.id_registro "+
			"                   WHERE rs1.estado_sec != 'X' "+
			"                         AND rf.estado_reg = 'A' "+
			"                         AND rf.fase_reg = 'C' "+
			"                   GROUP BY 1 "+
			"                   ORDER BY 1) compromiso "+
			"              ON mr.id_memo_requerimiento = compromiso.id_memo_requerimiento "+
			"       LEFT JOIN (SELECT r.id_memo_requerimiento, "+
			"                         COALESCE(Sum(rm1.monto_soles), 0) AS monto_dev "+
			"                    FROM bytsscom_bytsig.registro_sec rs1 "+
			"                         JOIN bytsscom_bytsig.registro_meta rm1 "+
			"                           ON rm1.id_registro = rs1.id_registro "+
			"                              AND rm1.id_corr_fase = rs1.id_corr_fase "+
			"                              AND rm1.id_corr_sec = rs1.id_corr_sec "+
			"                         JOIN bytsscom_bytsig.registro_fase rf "+
			"                           ON rs1.id_registro = rf.id_registro "+
			"                              AND rs1.id_corr_fase = rf.id_corr_fase "+
			"                         JOIN bytsscom_bytsig.registro r "+
			"                           ON rf.id_registro = r.id_registro "+
			"                   WHERE rs1.estado_sec != 'X' "+
			"                         AND rf.estado_reg = 'A' "+
			"                         AND rf.fase_reg = 'D' "+
			"                   GROUP BY 1 "+
			"                   ORDER BY 1) devengado "+
			"              ON mr.id_memo_requerimiento = devengado.id_memo_requerimiento "+
			"       LEFT JOIN (SELECT r.id_memo_requerimiento, "+
			"                         COALESCE(Sum(rm1.monto_soles), 0) AS monto_giro "+
			"                    FROM bytsscom_bytsig.registro_sec rs1 "+
			"                         JOIN bytsscom_bytsig.registro_meta rm1 "+
			"                           ON rm1.id_registro = rs1.id_registro "+
			"                              AND rm1.id_corr_fase = rs1.id_corr_fase "+
			"                              AND rm1.id_corr_sec = rs1.id_corr_sec "+
			"                         JOIN bytsscom_bytsig.registro_fase rf "+
			"                           ON rs1.id_registro = rf.id_registro "+
			"                              AND rs1.id_corr_fase = rf.id_corr_fase "+
			"                         JOIN bytsscom_bytsig.registro r "+
			"                           ON rf.id_registro = r.id_registro "+
			"                   WHERE rs1.estado_sec != 'X' "+
			"                         AND rf.estado_reg = 'A' "+
			"                         AND rf.fase_reg = 'G' "+
			"                   GROUP BY 1 "+
			"                   ORDER BY 1) giro "+
			"              ON mr.id_memo_requerimiento = giro.id_memo_requerimiento "+
			" WHERE mr.id_proyecto = :idproyecto "+
			"       AND mr.esta_requ <> 'X' ", nativeQuery = true)
	List<ProyectoEjecucionP> getEjecucionProyecto(@Param("idproyecto") Integer idproyecto);
}
