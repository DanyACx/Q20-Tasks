package com.quipucamayoc.Q20Tasks.controller.Usuario;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quipucamayoc.Q20Tasks.DTO.UsuarioDTO;
import com.quipucamayoc.Q20Tasks.service.UsuarioService;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	
	private final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@PostMapping("/crearUsuario")
	@PreAuthorize("hasAnyRole('CONTABILIDAD', 'USUARIO-PROYECTO-INTERNO')")
	public GenericResponse<?> createUser(@RequestBody UsuarioDTO usuarioDTO) {

		return this.service.createUser(usuarioDTO);
	}
	
	@GetMapping("/getDataUser")
	@PreAuthorize("hasAnyRole('PUBLIC-ROLE')")
	public GenericResponse<?> getDataUser(@Param("username") String username) {

		return this.service.getDataUser(username);
	}
}
