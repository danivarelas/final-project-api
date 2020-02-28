package com.brainstation.project.api.Util;

import java.io.UnsupportedEncodingException;

import io.jsonwebtoken.*;

import java.util.Date;

public class JWTProvider {

    public static String createJWT(String id, String name, String username, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // Let's set the JWT Claims
        JwtBuilder builder;
        try {
            builder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(now).claim("username", username)
                    .claim("name", name).signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"));
            String compact = builder.compact();
            return compact;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Claims decodeJWT(String jwt) {
        try {
            Claims claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt).getBody();
            return claims;
        } catch (UnsupportedEncodingException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public static boolean validateToken(String jwt) {
        Claims claims = decodeJWT(jwt);
        if (claims != null) {
            return true;
        }
        return false;
    }

}
