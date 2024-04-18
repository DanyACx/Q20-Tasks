package com.quipucamayoc.Q20Tasks.DTO;

import java.time.OffsetDateTime;
import java.util.Set;

import com.quipucamayoc.Q20Tasks.entity.Persona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private Persona persona;
	private String userName;
	private Integer locked;
	private Integer expired;
	private OffsetDateTime lastChangePasswordDate;
	private String password;
	private Integer idAuthenticationType;
	private Set<String> roles;
}
