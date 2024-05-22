package com.quipucamayoc.Q20Tasks.security.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quipucamayoc.Q20Tasks.entity.Usuario;
import com.quipucamayoc.Q20Tasks.projections.UsuarioP;
import com.quipucamayoc.Q20Tasks.repository.UsuarioRepository;
import com.quipucamayoc.Q20Tasks.security.jwt.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAutheticationFilter extends UsernamePasswordAuthenticationFilter{

	private JwtUtils jwtUtils;
	
	@Autowired
	private UsuarioRepository usuarioReporsitory;
	
	public JwtAutheticationFilter(JwtUtils jwtUtils, UsuarioRepository usuarioReporsitory) {
		this.jwtUtils = jwtUtils;
		this.usuarioReporsitory = usuarioReporsitory;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		Usuario usuario = null;
		String username = "";
		String password = "";
		
		try {
			usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			username = usuario.getUserName();
			password = usuario.getPassword();
		} catch (IOException e) {
			throw new RuntimeException(e); 
		}
		
		UsernamePasswordAuthenticationToken autheticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		return getAuthenticationManager().authenticate(autheticationToken);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User user = (User) authResult.getPrincipal(); // obtener detalles de usuario autenticado con exito
		
		UsuarioP usuarioP = usuarioReporsitory.getUsuario(user.getUsername());
		Map<String, Object> dataUsuario = new HashMap<>();
		dataUsuario.put("iduserauth", usuarioP.getIdUserAuth());
		dataUsuario.put("idunidad", usuarioP.getIdUnidad());
		dataUsuario.put("fullnameper", usuarioP.getFullNamePer());
		dataUsuario.put("idarea", usuarioP.getIdArea());
		dataUsuario.put("areaname", usuarioP.getAreaName());
		dataUsuario.put("idanioproceso", usuarioP.getIdAnioProceso());
		dataUsuario.put("idmonedanac", usuarioP.getIdMonedaNac());
		dataUsuario.put("idpersona", usuarioP.getIdPersona());
		dataUsuario.put("nombunidad", usuarioP.getNombUnidad());
		dataUsuario.put("username", usuarioP.getUserName());
		
		String token = jwtUtils.generateAccessToken(user.getUsername(), dataUsuario); // Se genera el token de acceso
		
		response.addHeader("Authorization", token);
		
		Map<String, Object> httpResponse = new HashMap<>();
		httpResponse.put("token", token);
		httpResponse.put("message", "Authentication Correcta");
		httpResponse.put("username", user.getUsername());
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
}
