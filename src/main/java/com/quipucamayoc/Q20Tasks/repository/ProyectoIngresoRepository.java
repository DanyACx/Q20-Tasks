package com.quipucamayoc.Q20Tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quipucamayoc.Q20Tasks.entity.ProyectoIngreso;
import com.quipucamayoc.Q20Tasks.entity.ProyectoIngresoId;
import com.quipucamayoc.Q20Tasks.projections.ProyectoIngresoP;

public interface ProyectoIngresoRepository extends JpaRepository<ProyectoIngreso, ProyectoIngresoId>{

	@Query(value = "SELECT pi.id_proyecto AS idProyecto, "+
			"       pi.id_corr_ingreso AS idCorrIngreso, "+
			"       pi.id_convenio AS idConvenio, "+
			"       pi.fech_reg_ingreso AS fechRegIngreso, "+
			"       pi.fech_aut_ingreso AS fechAutIngreso, "+
			"       pi.monto_ingreso AS montoIngreso, "+
			"       pi.estado_ingreso AS estadoIngreso, "+
			"       pi.id_fuente AS idFuente, "+
			"       pi.desc_ingreso AS descIngreso, "+
			"       pi.num_resol_ingreso AS numResolIngreso, "+
			"       pi.abre_fuente AS abreFuente, "+
			"       pi.hito_ingreso AS hitoIngreso, "+
			"       pi.tipo_ingreso AS tipoIngreso, "+
			"       pi.num_transferencia AS numTransferencia, "+
			"       pi.num_transferencia_display AS numTransferenciaDisplay1, "+
			"       f.abre_fuente AS abreFuente, "+
			"       ori.ano_transferencia || '-' || ori.sec_ejec_origen || '-' || ori.transferencia || '-' || ori.secuencia_transferencia AS numTransferenciaDisplay2 "+
			"FROM bytsscom_bytsig.vw_proyecto_ingreso pi "+
			"LEFT JOIN bytsscom_bytcore.bpm_task bpm ON bpm.process_key = 'proyecto_ingreso' "+
			"AND bpm.business_key = pi.id_proyecto::text||'-'||pi.id_corr_ingreso::text "+
			"LEFT JOIN bytsscom_bytcore.fuente f ON f.id_fuente = pi.id_fuente "+
			"LEFT JOIN bytsscom_bytsiaf.transferencia_origen ori ON (pi.num_transferencia = ori.transferencia_financiera_id) "+
			"WHERE pi.id_proyecto = :idproyecto "+
			"  AND pi.estado_ingreso != 'X' "+
			"ORDER BY pi.fech_reg_ingreso ", nativeQuery = true)
	List<ProyectoIngresoP> getIngresos(@Param("idproyecto") Integer idproyecto);
}
