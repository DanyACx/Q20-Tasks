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
			"       pr.fech_ini_proy AS fechIniProy, "+
			"       pr.fech_real_cierre_proy AS fechRealCierreProy, "+
			"       pr.codigo_proy AS codigoProy, "+
			"       pr.est_proy AS estProy, "+
			"       pr.sys_fech_registro AS sysFechRegistro, "+
			"       pr.id_convenio AS idConvenio, "+
			"       pr.id_coordinador AS idCoordinador, "+
			"       pr.nomb_est_proy AS nombEstProy, "+
			"       pr.nomb_coor AS nombCoor, "+
			"       pr.fech_fin_proy AS fechFinProy, "+
			"       pr.monto_total_proy AS montoTotalProy, "+
			"       pr.formato_conv AS formatoConv, "+
			"       per.id_unidad AS idUnidad, "+
			"       per.id_area AS idArea, "+
			"       per.nomb_unidad AS nombUnidad "+
			"FROM bytsscom_bytsig.vw_proyecto pr "+
			"LEFT JOIN bytsscom_bytcore.vw_personal per ON per.id_persona = pr.id_coordinador "+
			"WHERE pr.id_coordinador = :idpersona ", nativeQuery = true)
	List<ProyectoP> getProyectosPersona(@Param("idpersona") Integer idpersona);
	
	@Query(value = "SELECT pr.id_proyecto AS idProyecto, "+
			"       pr.nomb_proy AS nombProy, "+
			"       pr.fech_ini_proy AS fechIniProy, "+
			"       pr.durac_proy AS duracProy, "+
			"       pr.tipo_proy AS tipoProy, "+
			"       pr.claves_proy AS clavesProy, "+
			"       pr.just_proy AS justProy, "+
			"       pr.codigo_proy AS codigoProy, "+
			"       pr.est_proy AS estProy, "+
			"       pr.sys_fech_registro AS sysFechRegistro, "+
			"       pr.resumen_ejecutivo AS resumenEjecutivo, "+
			"       pr.id_convenio AS idConvenio, "+
			"       pr.import_fech_update AS importFechUpdate, "+
			"       pr.id_coordinador AS idCoordinador, "+
			"       pr.monto_total_proy AS montoTotalProy, "+
			"       conv.propietario_conv AS propietarioConv, "+
			"       ar.area_display_name AS areaDisplayName, "+
			"       ar.area_name AS areaName "+
			"FROM bytsscom_bytsig.proyecto pr "+
			"LEFT JOIN bytsscom_bytcore.area ar ON ar.id_area = pr.id_area "+
			"INNER JOIN bytsscom_bytsig.convenio conv ON conv.id_convenio = pr.id_convenio "+
			"WHERE pr.id_proyecto = :idproyecto ", nativeQuery = true)
	List<ProyectoP> getDatosGenerales(@Param("idproyecto") Integer idproyecto);
}
