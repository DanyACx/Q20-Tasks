package com.quipucamayoc.Q20Tasks.service;

import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_OK;
import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_WARNING;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_AUTH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipucamayoc.Q20Tasks.projections.UsuarioAuthP;
import com.quipucamayoc.Q20Tasks.repository.UsuarioRepository;
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
	public GenericResponse<UsuarioAuthP> login(String usuario, String password) {

		UsuarioAuthP usuarioAuthP = repository.getUsuarioAuth(usuario);

		if (usuarioAuthP != null) {
			if (usuarioAuthP.getLocked() == 0) {
				//if (PasswordHasher.isValid(password, usuarioAuthP.getPassword(), usuarioAuthP.getPasswordSalt())) {
					
					
					return new GenericResponse<>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", usuarioAuthP);
				//} else {
				//	return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Contraseña incorrecta, vuelva a intentar", null);
				//}
			}else {
				return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Cuenta bloqueada", null);
			}

		} else {
			return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Usuario no registrado en el sistema", null);
		}

	}
}
