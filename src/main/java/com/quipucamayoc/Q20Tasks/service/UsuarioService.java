package com.quipucamayoc.Q20Tasks.service;

import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_OK;
import static com.quipucamayoc.Q20Tasks.utils.Global.RPTA_WARNING;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_AUTH;
import static com.quipucamayoc.Q20Tasks.utils.Global.TIPO_DATA;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quipucamayoc.Q20Tasks.DTO.UsuarioDTO;
import com.quipucamayoc.Q20Tasks.entity.Usuario;
import com.quipucamayoc.Q20Tasks.projections.UsuarioAuthP;
import com.quipucamayoc.Q20Tasks.projections.UsuarioP;
import com.quipucamayoc.Q20Tasks.repository.UsuarioRepository;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	// Método para iniciar sesión
	public GenericResponse<UsuarioAuthP> login(String usuario, String password) {

		UsuarioAuthP usuarioAuthP = repository.getUsuarioAuth(usuario);

		if (usuarioAuthP != null) {
			if (usuarioAuthP.getLocked() == 0) {
				// if (PasswordHasher.isValid(password, usuarioAuthP.getPassword(),
				// usuarioAuthP.getPasswordSalt())) {

				return new GenericResponse<>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", usuarioAuthP);
				// } else {
				// return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Contraseña incorrecta,
				// vuelva a intentar", null);
				// }
			} else {
				return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Cuenta bloqueada", null);
			}

		} else {
			return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Usuario no registrado en el sistema", null);
		}

	}

	public GenericResponse<?> createUser(UsuarioDTO usuarioDTO) {

		String username = usuarioDTO.getUserName();
		Optional<Usuario> usuario1 = repository.getUserName(username);
		Usuario usuario = usuario1.orElse(null);

		if (usuario != null && usuario.getIdUserAuth() != null) { // El usuario esta registrado en Q20 web

			int cantidadUsuarios = repository.crearUsuario(usuario.getIdUserAuth(),
					passwordEncoder.encode(usuarioDTO.getPassword()));
			System.out.println("Se actualizarón: " + cantidadUsuarios + " Registros");
			Map<String, Object> map = new HashMap<>();

			map.put("iduserauth", usuario.getIdUserAuth());
			map.put("username", usuario.getUserName());
			map.put("locked", usuario.getLocked());
			map.put("expired", usuario.getExpired());

			return new GenericResponse<>(TIPO_AUTH, RPTA_OK, "Usuario creado con exito", map);
		} else {
			return new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Usuario no registrado en el sistema", null);
		}
	}

	public GenericResponse<?> getDataUser(String username) {
		
		UsuarioP usuarioP = repository.getUsuario(username);
		Map<String, Object> map = new HashMap<>();
		
		map.put("iduserauth", usuarioP.getIdUserAuth());
		map.put("idpersona", usuarioP.getIdPersona());
		map.put("username", usuarioP.getUserName());
		map.put("fullnameper", usuarioP.getFullNamePer());
		map.put("idarea", usuarioP.getIdArea());
		map.put("areaname", usuarioP.getAreaName());
		map.put("idanioproceso", usuarioP.getIdAnioProceso());
		map.put("idmonedanac", usuarioP.getIdMonedaNac());
		map.put("idunidad", usuarioP.getIdUnidad());
		map.put("nombunidad", usuarioP.getNombUnidad());
		
		return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Datos de usuario autenticado", map);

	}

}
