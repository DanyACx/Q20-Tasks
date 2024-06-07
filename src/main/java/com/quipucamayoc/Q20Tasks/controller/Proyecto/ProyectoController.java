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
	
	@GetMapping("/getActividades/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getActividades(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getActividades(idproyecto);
	}
	
	@GetMapping("/getEquipo/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getEquipo(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getEquipo(idproyecto);
	}
	
	@GetMapping("/getMetasPresupuestales/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getMetasPresupuestales(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getMetasPresupuestales(idproyecto);
	}
	
	@GetMapping("/getPresupuesto/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getPresupuesto(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getPresupuesto(idproyecto);
	}
	
	@GetMapping("/getIngresos/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getIngresos(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getIngresos(idproyecto);
	}
	
	@GetMapping("/getRequerimientos/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getRequerimientos(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getRequerimiento(idproyecto);
	}
	
	@GetMapping("/getEjecucion/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getEjecucion(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getEjecucion(idproyecto);
	}
	
	@GetMapping("/getGraficoEjecucion/{idproyecto}")
	@PreAuthorize("hasAnyRole('USUARIO-PROYECTO-INTERNO', 'USUARIO-PROYECTO-EXTERNO')")
	public GenericResponse<?> getGraficoEjecucion(@PathVariable Integer idproyecto) {
		
		return this.proyectoService.getGraficoEjecucion(idproyecto);
	}
}
