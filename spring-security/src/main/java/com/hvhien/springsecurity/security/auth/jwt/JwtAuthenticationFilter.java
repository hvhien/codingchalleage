package com.hvhien.springsecurity.security.auth.jwt;

import com.hvhien.springsecurity.security.auth.model.UserEntity;
import com.hvhien.springsecurity.security.auth.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Autowired
  private JwtProvider jwtProvider;

  @Autowired
  private UserService userService;
  @Autowired
  PasswordEncoder passwordEncoder;


  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try{
      String jwt=getJwtFromRequest(request);
      if (StringUtils.hasText(jwt) && jwtProvider.validateJwt(jwt)){
        String username=jwtProvider.getUsernameFromJwt(jwt);
        UserDetails user=userService.loadUserByUsername(username);
        if (null != user){
          // TODO: 12/21/2023 check with password decoded

          UsernamePasswordAuthenticationToken authenticationToken =
              new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
          authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
      }
    }catch (Exception e){
      logger.error("failed");
    }
    filterChain.doFilter(request,response);
  }

  private String getJwtFromRequest(HttpServletRequest request) {
    String bearerToken=request.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer ")){
      return bearerToken.substring(7);
    }
    return null;
  }
}
