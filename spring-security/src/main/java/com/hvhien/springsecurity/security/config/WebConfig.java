package com.hvhien.springsecurity.security.config;

import com.hvhien.springsecurity.security.auth.jwt.JwtAuthenticationFilter;
import com.hvhien.springsecurity.security.auth.jwt.JwtProvider;
import com.hvhien.springsecurity.security.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
public class WebConfig {
  //  private final JwtProvider jwtProvider;
  //  @Autowired
  //  private UserService service;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.authorizeHttpRequests(
//            (authz) -> {
//              authz
////                  .requestMatchers("/apis/v1/random")
////                  .permitAll()
////                  .requestMatchers("/apis/v1/login")
////                  .permitAll()
////                  .anyRequest()
////                  .authenticated();
//                      .requestMatchers("/apis/v1/login","/apis/v1/random").permitAll();
//            })
//        .httpBasic(Customizer.withDefaults());
    // unable CORS and disable CSRF
    //        http.cors(cors->cors.en());
    http.csrf(csrf -> csrf.disable());

    http.sessionManagement(
        httpSecuritySessionManagementConfigurer ->
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));
    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
    return new JwtAuthenticationFilter();
  }
  //  @Bean
  //  public CorsFilter corsFilter(){
  //    UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
  //    CorsConfiguration corsConfiguration=new CorsConfiguration();
  //    corsConfiguration.setAllowCredentials(true);
  ////    corsConfiguration.setAllowedOrigins();
  //
  //  }
}
