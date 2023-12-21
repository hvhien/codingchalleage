package com.hvhien.springsecurity.security.auth.jwt;

import com.hvhien.springsecurity.security.auth.model.CustomeUserDetail;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.util.Date;
@Component
@Slf4j
public class JwtProvider {
  //  private JwtTokenUtil jwtTokenUtil;
  private final String JWT_SECRET = "my-scret-key";
  private final long JWT_EXPIRATION = 604800000L;

  public String generateJwt(CustomeUserDetail userDetail) {
    Date now=new Date();
    Date expiryDate=new Date(now.getTime()+JWT_EXPIRATION);
    String jwt= Jwts.builder()
            .setSubject(Long.toString(userDetail.getUserEntity().getId()))
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
            .compact();
    return jwt;
  }

  public Long getUserIdFromJwt(String token){
    Claims claims=Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    return Long.parseLong(claims.getSubject());
  }

  public boolean validateJwt(String token){
    try{
      Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
      return true;
    }catch (MalformedJwtException exception){
      log.error("invalid token");
    }catch (ExpiredJwtException e){
      log.error("Expiry token");
    }catch (UnsupportedJwtException e){
      log.error("upsupport JWT token");
    }catch (IllegalArgumentException e){
      log.error("JWT claims string is empty");
    }
    return false;
  }

}
