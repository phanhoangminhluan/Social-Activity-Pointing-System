package com.edu.fpt.saps.helper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtHelper {

    private static final String SECRET = "</FUHM - Social Activity Grading System>";
    private static final long EXPIRATION_TIME = 16 * 7 * 24 * 60 * 60 * 60; // 16 weeks

    public static String generateToken() {
        return Jwts.builder()
                .setSubject("VALID TOKEN")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    public static boolean parseToken(String token) throws Exception {
        try {

        } catch (Exception e) {
            throw new Exception("This token is not generated from system");
        }
        String tokenBody = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        if (tokenBody.equals("VALID TOKEN")) {
            return true;
        }
        return false;


    }

}


//

