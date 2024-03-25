package com.quipucamayoc.Q20Tasks.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_auth", schema = "bytsscom_bytcore")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_auth")
	private Integer idUserAuth;
	
	@OneToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
	private Persona persona;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "locked")
	private Integer locked;
	
	@Column(name = "expired")
	private Integer expired;
	
	@Column(name = "last_logon_date")
	private OffsetDateTime lastLogonDate;
	
	@Column(name = "last_change_password_date")
	private OffsetDateTime lastChangePasswordDate;
	
	@Column(name = "failed_login_attempts")
	private Integer failedLoginAttempts;
	
	@Column(name = "secret_question", length = 510)
	private String secretQuestion;
	
	@Column(name = "secret_answer", length = 510)
	private String secretAnswer;
	
	@Column(name = "password" , length = 510)
	private String password;
	
	@Column(name = "password_salt", length = 510)
	private String passwordSalt;
	
	@Column(name = "expired_date")
	private LocalDate expiredDate;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "id_authentication_type")
	private Integer idAuthenticationType;
	
	@Column(name = "guid_user_auth")
	private String guidUserAuth;
	
}
