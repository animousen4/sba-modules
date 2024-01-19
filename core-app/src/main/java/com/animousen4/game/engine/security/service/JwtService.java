package com.animousen4.game.engine.security.service;

import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.util.DateTimeUtil;
import com.animousen4.game.engine.security.JwtSecretKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final DateTimeUtil dateTimeUtil;

    private final JwtSecretKey jwtSecretKey;

    @Value("${jwt.lifetime}")
    private Duration tokenLifeTime;

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof UserEntity customUserDetails) {
            claims.put("roles",
                    customUserDetails.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList())
            );
        }
        return generateToken(claims, userDetails);
    }
    public boolean isTokenSignatureValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(jwtSecretKey.getKey()).build().parseSignedContent(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isTokenTimeValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(
                        dateTimeUtil.getCurrentDate()
                )
                .expiration(dateTimeUtil.getDateWithDuration(
                        dateTimeUtil.getCurrentDate(),
                        tokenLifeTime
                ))
                .signWith(jwtSecretKey.getKey())
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(jwtSecretKey.getKey()).build().parseSignedClaims(token)
                .getPayload();
    }

}