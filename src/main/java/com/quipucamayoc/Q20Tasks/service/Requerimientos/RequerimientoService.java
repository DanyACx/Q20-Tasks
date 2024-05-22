package com.quipucamayoc.Q20Tasks.service.Requerimientos;

import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_OK;
import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_WARNING;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_AUTH;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_DATA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipucamayoc.Q20Tasks.projections.RequerimientoP;
import com.quipucamayoc.Q20Tasks.repository.RequerimientoRepository;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RequerimientoService {

	@Autowired
	private RequerimientoRepository repository;

	public RequerimientoService(RequerimientoRepository repository) {
		this.repository = repository;
	}

	public GenericResponse<?> getListadoRequerimientos(Integer idanio, Integer fechsolrequ, Integer idunidad, String areatipo, Integer idfuente) {

		List<RequerimientoP> listaRequerimientos = repository.getListRequerimientos(idanio, fechsolrequ, idunidad, areatipo, idfuente);
		
		Map<String, Object> map = new HashMap<>();

		map.put("Requerimientos", listaRequerimientos);
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Listado de requerimientos", map);

	}

}
