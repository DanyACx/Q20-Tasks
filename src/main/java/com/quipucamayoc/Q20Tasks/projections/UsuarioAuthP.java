package com.quipucamayoc.Q20Tasks.projections;

import java.time.LocalDate;

public interface UsuarioAuthP {

	Integer getIdUserAuth();

	Integer getIdPersona();

	String getUserName();

	Integer getLocked();

	Integer getExpired();

	Integer getFailedLoginAttempts();

	String getSecretQuestion();

	String getSecretAnswer();

	String getPassword();

	String getPasswordSalt();

	LocalDate getExpiredDate();

	String getObservation();

	Integer getIdAuthenticationType();

	String getGuidUserAuth();

	Integer getIdArea();

	String getMailContact();

	String getTenantId();
}
