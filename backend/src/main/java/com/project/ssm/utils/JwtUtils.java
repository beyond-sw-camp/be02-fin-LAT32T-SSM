package com.project.ssm.utils;


import com.project.ssm.member.exception.MemberAccountException;
import com.project.ssm.member.model.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;
import java.util.Date;


public class JwtUtils {

    // 일반 로그인 사용자 토큰 생성
    public static String generateAccessToken(Member member, String secretKey, Long expiredTimeMs) {

        Claims claims = Jwts.claims();
        claims.put("memberIdx", member.getMemberIdx());
        claims.put("memberId", member.getMemberId());
        claims.put("memberName", member.getMemberName());
        claims.put("department", member.getDepartment());
        claims.put("position", member.getPosition());
        claims.put("ROLE", member.getAuthority());

        byte[] secretBytes = secretKey.getBytes();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeMs))
                .signWith(Keys.hmacShaKeyFor(secretBytes), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    // 키 변환 메서드
    public static Key getSignKey(String secretKey) {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // 사용자 이름 가져오는 메서드
    public static String getUserMemberId(String token, String key) {
        return extractAllClaims(token, key).get("memberId", String.class);
    }

    public static String getMemberInfo(String token, String key) {
        return extractAllClaims(token, key).get("memberId", String.class);
    }

    public static String getAuthority(String token, String key) {
        return extractAllClaims(token, key).get("ROLE", String.class);
    }

    public static String checkJwtToken(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.split(" ")[1];
            return token;
        } else {
            throw MemberAccountException.forInvalidToken();
        }
    }

    // 토근에서 정보를 가져오는 코드가 계속 중복되어 사용되기 때문에 별도의 메서드로 만들어서 사용하기 위한 것
    public static Claims extractAllClaims(String token, String key) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSignKey(key))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            throw MemberAccountException.forInvalidToken();
        } catch (ExpiredJwtException e) {
            throw MemberAccountException.forExpiredToken();
        }
    }
}
