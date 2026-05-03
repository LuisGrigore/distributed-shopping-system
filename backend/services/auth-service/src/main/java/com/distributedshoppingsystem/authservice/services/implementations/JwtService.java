package com.distributedshoppingsystem.authservice.services.implementations;


import com.distributedshoppingsystem.authservice.dtos.ValidationResponse;
import com.distributedshoppingsystem.authservice.services.IJwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;
@Service
public class JwtService implements IJwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public String generateToken(UUID userId, String email) {
        return Jwts.builder()
                .subject(userId.toString())
                .claim("email", email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public ValidationResponse validateAndExtract(String token) {
        try {
            var claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            UUID userId = UUID.fromString(claims.getSubject());
            String email = claims.get("email", String.class);

            return ValidationResponse.builder()
                    .userId(userId)
                    .email(email)
                    .isActive(true) // o lo que corresponda
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}