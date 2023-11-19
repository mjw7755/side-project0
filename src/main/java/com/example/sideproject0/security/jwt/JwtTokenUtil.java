package com.example.sideproject0.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long EXPIRE_TIME = 1000 * 60 * 60;


    private final String secretKey;

    public JwtTokenUtil(@Value("${jwt.token.secretkey}")String secretKey) {
        this.secretKey = secretKey;
    }

    //JWT Token 발급
    public String createToken(String userId) {
        byte[] keyBytes = Decoders.BASE64.decode(this.secretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        Claims claims = Jwts.claims();
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(key)
                .compact();
    }

    // Claims에서 loginId 꺼내기
    public String getLoginId(String token) {
        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey))).build().parseClaimsJws(token).getBody().get("userId").toString();
    }

    // 밝급된 Token이 만료 시간이 지났는지 체크
    public boolean isExpired(String token) {
        Date expiredDate = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey))).build().parseClaimsJws(token).getBody().getExpiration();
        // Token의 만료 날짜가 지금보다 이전인지 check
        return expiredDate.before(new Date());
    }
}
