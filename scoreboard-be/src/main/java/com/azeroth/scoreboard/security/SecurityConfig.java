package com.azeroth.scoreboard.security;

import com.azeroth.scoreboard.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
  private UserService userService;

  public SecurityConfig(UserService userService) {
    this.userService = userService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
    http
      .cors(Customizer.withDefaults()) // 
      .csrf(csrf -> csrf.disable()) // Disable CSRF protection as we are using tokens
      .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))  // Allow frames from the same origin
      .sessionManagement(session -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // No sessions will be created
      )
      .authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/seasons", "/seasons/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/leagues", "/leagues/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/matches", "/matches/**").permitAll()
        .requestMatchers("/signup").permitAll()  // Allow unauthenticated access to signUp
        .requestMatchers("/login").permitAll()  // Allow public access to login
        .anyRequest().authenticated()  // All other requests require authentication
      )
      .userDetailsService(userService)
      .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
