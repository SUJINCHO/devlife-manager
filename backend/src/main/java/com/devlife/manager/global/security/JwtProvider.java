package com.devlife.manager.global.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * JWT 생성 및 검증을 담당하는 클래스
 */
@Component
public class JwtProvider {

    private final Key key = Keys.hmacShaKeyFor("my-secret-key-my-secret-key-my-secret-key".getBytes());


    /**
     * JWT 토큰 생성
     */
    public String createToken(Long userId) {
        Date now = new Date();
        long EXPIRATION = 1000 * 60 * 60; // 1시간

        return Jwts.builder()
                .setSubject(String.valueOf(userId)) // 사용자 식별 정보
                .setIssuedAt(now)  // 발급 시간
                .setExpiration(new Date(now.getTime() + EXPIRATION)) // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256)  // 서명
                .compact();
    }
}