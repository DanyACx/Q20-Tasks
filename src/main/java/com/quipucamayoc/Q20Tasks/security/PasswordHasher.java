package com.quipucamayoc.Q20Tasks.security;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class PasswordHasher {

	/**
	 * Nombre del algoritmo de hash.
	 */
	private static final String ALGORITHM = "HmacSHA512";

	/**
	 * Longitud del <code>salt</code>. Igual al tamaÃƒÂ±o del resultado del
	 * algoritmo.
	 */
	private static final int SALT_LENGTH = 64;

	/**
	 * NÃƒÂºmero de iteraciones a realizar.
	 */
	private static final int ITERATIONS = 1000;

	/**
	 * Nombre del conjunto de caracteres para codificar cadenas de texto.
	 */
	private static final String CHARSET_NAME = "UTF-8";

	/**
	 * Representa el resultado de una operaciÃƒÂ³n de <code>hash</code> con
	 * <code>salt</code>.
	 *
	 * @author Jose Manuel Cejudo Gausi
	 */
	public static class PasswordHash {

		/**
		 * Contiene el valor de <code>hash</code>.
		 */
		private final byte[] hash;

		/**
		 * Contiene el valor de <code>salt</code>.
		 */
		private final byte[] salt;

		/**
		 * Construye una nueva instancia con los valores indicados.
		 *
		 * @param hash el valor de <code>hash</code>.
		 * @param salt el valor de <code>salt</code>.
		 */
		private PasswordHash(final byte[] hash, final byte[] salt) {

			this.hash = hash;
			this.salt = salt;

		}

		/**
		 * Devuelve el valor de <code>hash</code>.
		 *
		 * @return el valor.
		 */
		public byte[] getHash() {

			return hash;

		}

		public String getHashString() {

			return HelperString.bytesToHex(hash);

		}

		/**
		 * Devuelve el valor de <code>salt</code>.
		 *
		 * @return el valor.
		 */
		public byte[] getSalt() {

			return salt;

		}

	}

	/**
	 * Constructor privado para impedir la instanciaciÃƒÂ³n de esta clase de
	 * utilidad.
	 */
	private PasswordHasher() {

		super();

	}

	/**
	 * Calcula el <code>hash</code> del valor indicado.
	 * <p>
	 * Este mÃƒÂ©todo genera un valor de <code>salt</code> aleatorio y lo utiliza
	 * para calcular repetitivamente tantas operaciones de <code>hash</code> como
	 * indique {@link #ITERATIONS}.
	 * <p>
	 * El objeto {@link PasswordHash}devuelto contiene el <code>hash</code>
	 * calculado y el <code>salt</code> generado.
	 *
	 * @param value el valor para el que calcular el <code>hash</code>.
	 * @return el resultado del cÃƒÂ¡lculo <code>hash</code>.
	 * @throws Exception
	 */
	public static PasswordHash hash(final String value) throws Exception {

		final byte[] salt = new byte[SALT_LENGTH];
		final SecureRandom rnd = new SecureRandom();
		rnd.nextBytes(salt);

		return hash(value, salt);

	}

	/**
	 * Calcula el <code>hash</code> del valor indicado usando el <code>salt</code>
	 * indicado.
	 * <p>
	 * El objeto {@link PasswordHash}devuelto contiene el <code>hash</code>
	 * calculado y el <code>salt</code> generado.
	 *
	 * @param value el valor para el que calcular el <code>hash</code>.
	 * @param salt  el valor de <code>salt</code> a utilizar.
	 * @return el resultado del cÃƒÂ¡lculo <code>hash</code>.
	 * @throws Exception
	 */
	private static PasswordHash hash(final String value, final byte[] salt) throws Exception {

		try {
			byte[] retVal;
			final byte[] valueBytes = value.getBytes(CHARSET_NAME);
			final Mac mac = Mac.getInstance(ALGORITHM);
			final Key key = new SecretKeySpec(salt, ALGORITHM);
			mac.init(key);
			retVal = mac.doFinal(valueBytes);
			for (int i = 1; i < ITERATIONS; i++) {
				retVal = mac.doFinal(retVal);
			}
			return new PasswordHash(retVal, salt);

		} catch (final Exception e) {
			throw new Exception(e);
		}

	}

	/**
	 * Comprueba si el <code>hash</code> calculado para el valor y el
	 * <code>salt</code> indicados es igual al <code>hash</code> correcto indicado.
	 * <p>
	 * Este mÃƒÂ©todo permite comprobar si un valor es integro con respecto al
	 * <code>hash</code>.
	 *
	 * @param value       el valor a comprobar.
	 * @param correctHash el <code>hash</code> correcto.
	 * @param salt        el <code>salt</code> a utilizar para la generaciÃƒÂ³n del
	 *                    <code>hash</code> de <code>value</code>. Debe ser el mismo
	 *                    que el utilizado para calcular <code>hash</code>.
	 * @return <code>true</code> si el <code>hash</code> de <code>value</code>
	 *         usando <code>salt</code> es igual a <code>correctHash</code>.
	 * @throws Exception
	 */
	public static boolean isValid(final String value, final byte[] correctHash, final byte[] salt) throws Exception {

		final PasswordHash ph = hash(value, salt);
		return Arrays.equals(ph.getHash(), correctHash);

	}

	/**
	 * Comprueba si el <code>hash</code> calculado para el valor y el
	 * <code>salt</code> indicados es igual al <code>hash</code> correcto indicado.
	 * <p>
	 * Este mÃƒÂ©todo permite comprobar si un valor es integro con respecto al
	 * <code>hash</code>.
	 *
	 * @param value       el valor a comprobar.
	 * @param correctHash el <code>hash</code> correcto.
	 * @param salt        el <code>salt</code> a utilizar para la generaciÃƒÂ³n del
	 *                    <code>hash</code> de <code>value</code>. Debe ser el mismo
	 *                    que el utilizado para calcular <code>hash</code>.
	 * @return <code>true</code> si el <code>hash</code> de <code>value</code>
	 *         usando <code>salt</code> es igual a <code>correctHash</code>.
	 */
	public static boolean isValid(final String value, final String correctHash, final String salt) {
		try {
			final PasswordHash ph;
			ph = hash(value, HelperString.hexToBytes(salt));
			// System.out.println("Cadena 1: " + ph);
			// System.out.println("Cadena 2: " + correctHash);
			return ph.getHashString().equals(correctHash);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			return false;
		}

	}

}
