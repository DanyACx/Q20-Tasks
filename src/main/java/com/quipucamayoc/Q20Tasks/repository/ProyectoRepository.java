package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quipucamayoc.Q20Tasks.entity.Proyecto;
import com.quipucamayoc.Q20Tasks.projections.ProyectoP;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

	@Query(value = "SELECT pr.id_proyecto AS idProyecto, "+
			"       pr.nomb_proy AS nombProy, "+
			"       pr.codigo_proy AS codigoProy, "+
			"       pr.est_proy AS estProy, "+
			"       pr.sys_fech_registro AS sysFechRegistro, "+
			"       pr.id_convenio AS idConvenio, "+
			"       pr.id_coordinador AS idCoordinador, "+
			"       pr.sys_fech_registro AS fechaRegistro, "+
			"       pr.nomb_coor AS nombCoor "+
			"FROM bytsscom_bytsig.vw_proyecto pr "+
			"WHERE pr.id_coordinador = :idpersona ", nativeQuery = true)
	List<ProyectoP> getProyectosPersona(@Param("idpersona") Integer idpersona);
	
	@Query(value = "SELECT pr.id_proyecto AS idProyecto, "+
			"       pr.nomb_proy AS nombProy, "+
			"       pr.fech_ini_proy AS fechIniProy, "+
			"       pr.fech_fin_proy AS fechFinProy, "+
			"       pr.fech_real_cierre_proy AS fechRealCierreProy, "+
			"       pr.durac_proy AS duracProy, "+
			"       pr.tipo_proy AS tipoProy, "+
			"       pr.claves_proy AS clavesProy, "+
			"       pr.tipo_proy AS tipoProyecto, "+
			"       pr.just_proy AS justProy, "+
			"       pr.codigo_proy AS codigoProy, "+
			"       pr.est_proy AS estProy, "+
			"       pr.id_area AS idArea, "+
			"       pr.sys_fech_registro AS sysFechRegistro, "+
			"       pr.resumen_ejecutivo AS resumenEjecutivo, "+
			"       pr.id_convenio AS idConvenio, "+
			"       pr.import_fech_update AS importFechUpdate, "+
			"       pr.id_coordinador AS idCoordinador, "+
			"       pr.monto_total_proy AS montoTotalProy, "+
			"       conv.propietario_conv AS propietarioConv, "+
			"       ar.area_display_name AS nombUnidadCoordinadorProy, "+
			"       ar.area_name AS codUnidadCoordinadorProy, "+
			"       per.full_name_per AS nameCoordinador, "+
			"       per.cod_unidad AS codUnidadCoordinador, "+
			"       per.nomb_unidad AS nombUnidadCoordinador, "+
			"       per.id_unidad AS idUnidadCoordinador, "+
			"       per.id_area AS idAreaCoordinador, "+
			"       (SELECT string_agg(cont.data_contacto, ';') "+
			"          FROM bytsscom_bytcore.persona_contacto cont "+
			"         WHERE cont.id_persona = pr.id_coordinador AND cont.est_contacto = 1 "+
			"         AND (cont.id_tipo_contacto = 118 OR cont.id_tipo_contacto = 20449) ) AS emailCoordinador "+
			"FROM bytsscom_bytsig.proyecto pr "+
			"INNER JOIN bytsscom_bytcore.vw_personal per "+
			"		ON per.id_persona = pr.id_coordinador "+
			"LEFT JOIN bytsscom_bytcore.area ar ON ar.id_area = pr.id_area "+
			"INNER JOIN bytsscom_bytsig.convenio conv ON conv.id_convenio = pr.id_convenio "+
			"WHERE pr.id_proyecto = :idproyecto ", nativeQuery = true)
	ProyectoP getDatosGenerales(@Param("idproyecto") Integer idproyecto);
	
	@Query(value = "SELECT pro.id_proyecto AS idProyecto, "+
			"       ppto.desc_ppto AS descPpto, "+
			"       cl.id_clasificador AS idClasificador, "+
			"       cl.cod_clasif AS codClasif, "+
			"       ppto.tipo_ppto AS tipoPpto, "+
			"       ppto.id_corr_ppto AS idCorrPpto, "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 2 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) AS rdr, "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 14 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) AS ra, "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 15 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) AS r18, "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 4 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) AS rnp, "+
			"       (Sum(CASE "+
			"             WHEN ppm.id_fuente = 2 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) + "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 14 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) + "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 15 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) + "+
			"       Sum(CASE "+
			"             WHEN ppm.id_fuente = 4 THEN ppm.monto_meta "+
			"             ELSE 0 "+
			"           END) ) AS montoPpto, "+
			"       ppto.id_anio AS idAnio "+
			"  FROM bytsscom_bytsig.proyecto pro "+
			"       INNER JOIN bytsscom_bytsig.proyecto_ppto ppto "+
			"               ON ppto.id_proyecto = pro.id_proyecto "+
			"       INNER JOIN bytsscom_bytcore.clasificador cl "+
			"               ON cl.id_clasificador = ppto.id_clasificador "+
			"       LEFT JOIN (SELECT pm.id_proyecto, "+
			"                         pm.id_corr_ppto, "+
			"                         pm.id_tarea_meta, "+
			"                         tm.id_fuente, "+
			"                         pm.monto_meta "+
			"                    FROM bytsscom_bytsig.proyecto_ppto_meta pm "+
			"                         INNER JOIN bytsscom_bytsig.tarea_meta tm "+
			"                                 ON tm.id_tarea_meta = pm.id_tarea_meta) ppm "+
			"              ON ppm.id_proyecto = ppto.id_proyecto "+
			"                 AND ppm.id_corr_ppto = ppto.id_corr_ppto "+
			" WHERE pro.id_proyecto = :idproyecto "+
			" GROUP BY pro.id_proyecto, "+
			"          ppto.desc_ppto, "+
			"          cl.id_clasificador, "+
			"          cl.cod_clasif, "+
			"          ppto.tipo_ppto, "+
			"          ppto.id_corr_ppto, "+
			"          ppto.id_anio "+
			"  ORDER BY ppto.id_corr_ppto ", nativeQuery = true)
	List<ProyectoP> getPresupuesto(@Param("idproyecto") Integer idproyecto);
}
