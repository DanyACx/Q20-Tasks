package com.quipucamayoc.Q20Tasks.service;

import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_OK;
import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_WARNING;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_AUTH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipucamayoc.Q20Tasks.entity.Usuario;
import com.quipucamayoc.Q20Tasks.projections.UsuarioP;
import com.quipucamayoc.Q20Tasks.repository.UsuarioRepository;
import com.quipucamayoc.Q20Tasks.security.PasswordHasher;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	// Método para iniciar sesión
	public GenericResponse<UsuarioP> login(String usuario, String password) {
		
		UsuarioP usuariop = repository.getUsuario(usuario);

		if (PasswordHasher.isValid(password, usuariop.getPassword(), usuariop.getPasswordSalt())) {
			return new GenericResponse<UsuarioP>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", usuariop);
		} else {
			return new GenericResponse<UsuarioP>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", null);
		}
	}
}
