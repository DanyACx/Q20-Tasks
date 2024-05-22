package com.quipucamayoc.Q20Tasks.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.quipucamayoc.Q20Tasks.repository.UsuarioRepository;
import com.quipucamayoc.Q20Tasks.security.filters.JwtAutheticationFilter;
import com.quipucamayoc.Q20Tasks.security.filters.JwtAuthorizationFilter;
import com.quipucamayoc.Q20Tasks.security.jwt.JwtUtils;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtAuthorizationFilter authorizationFilter;
	
	@Autowired
	private UsuarioRepository usuarioReporsitory;
	
	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
		
		JwtAutheticationFilter jwtAutheticationFilter = new JwtAutheticationFilter(jwtUtils, usuarioReporsitory);
		jwtAutheticationFilter.setAuthenticationManager(authenticationManager);
		jwtAutheticationFilter.setFilterProcessesUrl("/login"); // se puede cambiar
		
		
		return httpSecurity
				.csrf(config -> config.disable()) // inhabilitar el csrf (para no trabajar con formularios)
				.authorizeHttpRequests(auth -> { // acceso a las urls
					auth.requestMatchers("/login").permitAll(); // permitir a todos
					auth.anyRequest().authenticated(); // cualquier otra ruta, debe estar autenticado
				})
				.sessionManagement(session -> {
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS); // para no manejar sesión
				})
				.addFilter(jwtAutheticationFilter)
				.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
    	  
    	String idForEncode = "bcrypt";
    	  
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        
        return new DelegatingPasswordEncoder(idForEncode, encoders);
    }
	
    @SuppressWarnings("removal")
	@Bean
	AuthenticationManager autheticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
    	//System.out.println(new BCryptPasswordEncoder().encode("11111"));
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder)
				.and().build();
	}
    
}
