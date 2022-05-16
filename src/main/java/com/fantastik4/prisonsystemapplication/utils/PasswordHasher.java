package com.fantastik4.prisonsystemapplication.utils;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordHasher {

    public static String hash(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
        return encoder.encode(password);
    }

    public static boolean matches(String password, String hashedPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hashedPassword);
    }


}
