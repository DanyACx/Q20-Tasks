package com.quipucamayoc.Q20Tasks.controller.Proyecto;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quipucamayoc.Q20Tasks.service.Proyectos.ProyectoService;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

@RestController
@RequestMapping("/api/v1/proyecto")
public class ProyectoController {

private final ProyectoService proyectoService;
	
	public ProyectoController(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	
	@GetMapping("/getListProyectos/{idpersona}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getListRequ(@PathVariable Integer idpersona) {
		
		return this.proyectoService.getListProyectos(idpersona);
	}
	
	@GetMapping("/getDatosGenerales/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getDatosGenerales(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getDatosGenerales(idproyecto);
	}
}
