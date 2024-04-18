package com.quipucamayoc.Q20Tasks.entity;

import java.time.OffsetDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_auth_app", schema = "bytsscom_bytcore")
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

	@Column(name = "last_change_password_date")
	private OffsetDateTime lastChangePasswordDate;

	@Column(name = "password", length = 510)
	private String password;

	@Column(name = "id_authentication_type")
	private Integer idAuthenticationType;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Rol.class)
	@JoinTable(name = "user_role", schema = "bytsscom_bytcore", joinColumns = @JoinColumn(name = "id_user_auth"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Rol> roles; // Set no permite tener elementos duplicados

}
