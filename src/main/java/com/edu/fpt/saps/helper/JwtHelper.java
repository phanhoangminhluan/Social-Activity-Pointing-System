package com.edu.fpt.saps.helper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtHelper {

    private static final String SECRET = "</FUHM - Social Activity Grading System>";
    private static final long EXPIRATION_TIME = 16 * 7 * 24 * 60 * 60 * 60; // 16 weeks

    public static String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
//
//    public static String parseToken(String token) {
//
//    }

}
