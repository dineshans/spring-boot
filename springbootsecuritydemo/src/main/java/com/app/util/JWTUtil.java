package com.app.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    private static  final String SECRET_KEY = "12345678901234567890123456789012";
    //private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String userName, long expiryMinutes) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryMinutes * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
