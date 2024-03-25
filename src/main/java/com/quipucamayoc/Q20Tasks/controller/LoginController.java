package com.quipucamayoc.Q20Tasks.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quipucamayoc.Q20Tasks.projections.UsuarioP;
import com.quipucamayoc.Q20Tasks.service.UsuarioService;
import com.quipucamayoc.Q20Tasks.utils.GenericResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }
	
    @PostMapping("/login")
    public GenericResponse<UsuarioP> login(HttpServletRequest request){
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        return this.service.login(usuario, password);
    }
	
}
