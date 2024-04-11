package com.quipucamayoc.Q20Tasks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "role", schema = "bytsscom_bytcore")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role", length = 36)
	private String idRole;

	@Column(name = "role_name", length = 100)
	private String roleName;

	@Column(name = "role_description", length = 1000)
	private String roleDescription;

	@Column(name = "id_application", length = 36)
	private String idApplication;
	
	@Column(name = "role_code", length = 50)
	private String roleCode;

}
