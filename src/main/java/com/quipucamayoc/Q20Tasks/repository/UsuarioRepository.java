package com.quipucamayoc.Q20Tasks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quipucamayoc.Q20Tasks.entity.Usuario;
import com.quipucamayoc.Q20Tasks.projections.UsuarioP;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "select * from bytsscom_bytcore.user_auth where user_name = :usuario and password = :password", nativeQuery = true)
	Optional<Usuario> login(@Param("usuario") String usuario, @Param("password") String password);
	

	@Query(value = "SELECT ua.id_user_auth AS idUserAuth, ua.id_persona AS idPersona, ua.user_name AS userName, ua.locked,"+
			"ua.expired, ua.failed_login_attempts AS failedLoginAttempts, ua.secret_question as secretQuestion,"+
			"ua.secret_answer AS secretAnswer, ua.password, ua.password_salt AS passwordSalt, ua.expired_date AS expiredDate,"+
			"ua.observation, ua.id_authentication_type AS idAuthenticationType, ua.guid_user_auth AS guidUserAuth, "+
			"us.id_area AS idArea, us.mail_contact AS mailContact, us.tenant_id AS tenantId "+
	        "FROM bytsscom_bytcore.user_auth ua "+
	        "INNER JOIN bytsscom_bytcore.vw_users us ON us.id_user_auth = ua.id_user_auth "+
	        "LEFT JOIN bytsscom_bytcore.vw_persona pe ON pe.id_persona = ua.id_persona "+
	        "WHERE UPPER(ua.user_name) = UPPER(:usuario) ", nativeQuery = true)
	UsuarioP getUsuario(@Param("usuario") String usuario);
}
