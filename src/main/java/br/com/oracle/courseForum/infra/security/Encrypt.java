package br.com.oracle.courseForum.infra.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encrypt {
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
