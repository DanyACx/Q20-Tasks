package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface ProyectoActividadP {

	 String getDescActividad();
	
	 BigDecimal getMetaActividad();
	
	 Integer getIdCorrActividad();
	
	 String getNombUnimed();
	
	 Integer getIdProyecto();
	
	 Integer getIdCorrComponente();
	
	 Date getIniActividad();
	
	 Date getFinActividad();
	
	 String getIdActividadConvenio();
}
