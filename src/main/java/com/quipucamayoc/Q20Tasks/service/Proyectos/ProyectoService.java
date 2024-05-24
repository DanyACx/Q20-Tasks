package com.quipucamayoc.Q20Tasks.service.Proyectos;

import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_OK;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_DATA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipucamayoc.Q20Tasks.projections.ProyectoActividadP;
import com.quipucamayoc.Q20Tasks.projections.ProyectoEquipoP;
import com.quipucamayoc.Q20Tasks.projections.ProyectoIngresoP;
import com.quipucamayoc.Q20Tasks.projections.ProyectoP;
import com.quipucamayoc.Q20Tasks.projections.TareaMetaP;
import com.quipucamayoc.Q20Tasks.repository.ProyectoActividadRepository;
import com.quipucamayoc.Q20Tasks.repository.ProyectoEquipoRepository;
import com.quipucamayoc.Q20Tasks.repository.ProyectoIngresoRepository;
import com.quipucamayoc.Q20Tasks.repository.ProyectoRepository;
import com.quipucamayoc.Q20Tasks.repository.TareaMetaRepository;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private ProyectoActividadRepository proyectoActividadRepository;
	
	@Autowired
	private ProyectoEquipoRepository proyectoEquipoRepository;
	
	@Autowired
	private TareaMetaRepository tareaMetaRepository;
	
	@Autowired
	private ProyectoIngresoRepository proyectoIngresoRepository;
	
	public ProyectoService(ProyectoRepository proyectoRepository, ProyectoActividadRepository proyectoActividadRepository, ProyectoEquipoRepository proyectoEquipoRepository, TareaMetaRepository tareaMetaRepository, ProyectoIngresoRepository proyectoIngresoRepository) {
		this.proyectoRepository = proyectoRepository;
		this.proyectoActividadRepository = proyectoActividadRepository;
		this.proyectoEquipoRepository = proyectoEquipoRepository;
		this.tareaMetaRepository = tareaMetaRepository;
		this.proyectoIngresoRepository = proyectoIngresoRepository;
	}
	
	public GenericResponse<?> getListProyectos(Integer idpersona) {

		List<ProyectoP> listaProyectos = proyectoRepository.getProyectosPersona(idpersona);
		
		Map<String, Object> listProyectos = new HashMap<>();

		listProyectos.put("Proyectos", listaProyectos);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Listado de proyectos", listProyectos);

	}
	
	public GenericResponse<?> getDatosGenerales(Integer idproyecto) {

		List<ProyectoP> datosGenerales = proyectoRepository.getDatosGenerales(idproyecto);
		
		Map<String, Object> dataGeneral = new HashMap<>();

		dataGeneral.put("DatosGenerales", datosGenerales);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Datos Generales", dataGeneral);

	}
	
	public GenericResponse<?> getActividades(Integer idproyecto) {

		List<ProyectoActividadP> actividades = proyectoActividadRepository.getActividades(idproyecto);
		
		Map<String, Object> getActividades = new HashMap<>();

		getActividades.put("Actividades", actividades);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Actividades", getActividades);

	}
	
	public GenericResponse<?> getEquipo(Integer idproyecto) {

		List<ProyectoEquipoP> equipo = proyectoEquipoRepository.getEquipo(idproyecto);
		
		Map<String, Object> getEquipo = new HashMap<>();

		getEquipo.put("Equipo", equipo);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Equipo", getEquipo);

	}
	
	public GenericResponse<?> getMetasPresupuestales(Integer idproyecto) {

		List<TareaMetaP> metaPresu = tareaMetaRepository.getMetasPresupuestales(idproyecto);
		
		Map<String, Object> getMetaPresu = new HashMap<>();

		getMetaPresu.put("Metas Presupuestales", metaPresu);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Metas Presupuestales", getMetaPresu);

	}
	
	public GenericResponse<?> getPresupuesto(Integer idproyecto) {

		List<ProyectoP> presupuesto = proyectoRepository.getPresupuesto(idproyecto);
		
		Map<String, Object> getPresupuesto = new HashMap<>();

		getPresupuesto.put("Presupuesto", presupuesto);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Presupuesto", getPresupuesto);

	}
	
	public GenericResponse<?> getIngresos(Integer idproyecto) {

		List<ProyectoIngresoP> ingresos = proyectoIngresoRepository.getIngresos(idproyecto);
		
		Map<String, Object> getIngresos = new HashMap<>();

		getIngresos.put("Ingresos", ingresos);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Ingresos", getIngresos);

	}
	
}
