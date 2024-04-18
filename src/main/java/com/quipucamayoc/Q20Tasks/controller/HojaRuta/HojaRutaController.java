package com.quipucamayoc.Q20Tasks.controller.HojaRuta;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hojaruta")
public class HojaRutaController {

	@GetMapping("/search")
	@PreAuthorize("hasAnyRole('CONTABILIDAD', 'USUARIO-PROYECTO-INTERNO')")
	public String searchHojaRuta() {
		return "Bandeja de HR";
	}
	
	@GetMapping("/reprogramar")
	@PreAuthorize("hasAnyRole('BPM.ALM.REPROGRAMAR.SOLICITUD')")
	public String reprogramar() {
		return "Bandeja de Reprogramar";
	}
	
}
