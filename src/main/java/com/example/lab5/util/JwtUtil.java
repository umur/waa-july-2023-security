package com.example.lab5.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {
  private final String secretKey = "secret_key";
  private final long jwtExpiration = 900000;

  private final long refreshJwtExpiration = 3600000;

  public String extractUsername(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("roles",userDetails.getAuthorities());

    return doGenerateToken(claims, userDetails.getUsername());
  }

  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return doGenerateToken(extraClaims, userDetails.getUsername());
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser()
              .setSigningKey(secretKey)
              .parseClaimsJws(token);
      return true;
    } catch (SignatureException e) {
      System.out.println(e.getMessage());
    } catch (MalformedJwtException e) {
      System.out.println(e.getMessage());
    } catch (ExpiredJwtException e) {
      System.out.println(e.getMessage());
    } catch (UnsupportedJwtException e) {
      System.out.println(e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }


  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  public Claims getAllClaimsFromToken(String token) {
    return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody();
  }

  private String doGenerateToken(Map<String, Object> claims, String subject) {
    return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
  }


  public String doGenerateToken(String subject) {
    return Jwts.builder()
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + refreshJwtExpiration))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
  }

  public String generateRefreshToken(String email) {
    return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + refreshJwtExpiration))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
  }
}
