package com.quipucamayoc.Q20Tasks.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Sha512PasswordEncoder implements PasswordEncoder{

    private static final int SALT_LENGTH = 64; // Longitud del salt en bytes

    @Override
    public String encode(CharSequence rawPassword) {
        // Generar un salt aleatorio
        byte[] salt = generateSalt();
        // Aplicar el salt a la contraseña
        String saltedPassword = rawPassword.toString() + new String(salt);

        // Encriptar la contraseña con SHA-512
        return hashWithSHA512(saltedPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Obtener el salt del password encriptado
        String storedSalt = encodedPassword.substring(0, SALT_LENGTH * 2); // El salt es una cadena hexadecimal de longitud SALT_LENGTH

        // Aplicar el salt al password en bruto
        String saltedPassword = rawPassword.toString() + storedSalt;

        // Encriptar la contraseña ingresada
        String hashedPassword = hashWithSHA512(saltedPassword);

        // Comparar el password encriptado con el password almacenado
        return hashedPassword.equals(encodedPassword);
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    private String hashWithSHA512(String input) {
        StringBuilder result = new StringBuilder();
        try {
        	System.out.println("holaaa");
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(input.getBytes());
            byte[] digested = md.digest();
            for (byte b : digested) {
                result.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
        return result.toString();
    }
}
