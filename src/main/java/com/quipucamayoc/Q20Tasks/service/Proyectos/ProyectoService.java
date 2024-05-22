package com.quipucamayoc.Q20Tasks.service.Proyectos;

import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_OK;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_DATA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipucamayoc.Q20Tasks.projections.ProyectoP;
import com.quipucamayoc.Q20Tasks.repository.ProyectoRepository;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	public ProyectoService(ProyectoRepository proyectoRepository) {
		this.proyectoRepository = proyectoRepository;
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
	
}
