package com.quipucamayoc.Q20Tasks.controller.Requerimiento;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quipucamayoc.Q20Tasks.service.Requerimientos.RequerimientoService;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

@RestController
@RequestMapping("/api/v1/requerimiento")
public class RequerimientoController {

	private final RequerimientoService service;
	
	public RequerimientoController(RequerimientoService service) {
		this.service = service;
	}
	
	@GetMapping("/getListRequerimientos")
	@PreAuthorize("hasAnyRole('PUBLIC-ROLE')")
	public GenericResponse<?> getListRequ(@RequestParam(required = false) Integer idanio, @RequestParam(required = false) Integer fechsolrequ, @RequestParam(required = false) Integer idunidad, @RequestParam(required = false) String areatipo, @RequestParam(required = false) Integer idfuente) {
		
		return this.service.getListadoRequerimientos(idanio, fechsolrequ, idunidad, areatipo, idfuente);
	}
}
