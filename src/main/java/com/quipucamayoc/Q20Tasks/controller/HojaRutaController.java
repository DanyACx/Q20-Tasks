package com.quipucamayoc.Q20Tasks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HojaRutaController {

	@GetMapping("/searchHojaRuta")
	public String searchHojaRuta() {
		return "Bandeja de HR";
	}
	
}
