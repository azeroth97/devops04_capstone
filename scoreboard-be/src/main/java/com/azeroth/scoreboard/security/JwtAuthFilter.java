package com.azeroth.scoreboard.security;

import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.azeroth.scoreboard.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
  private JwtUtil jwtUtil;
  private UserService userService;

  public JwtAuthFilter(JwtUtil jwtUtil, UserService userService) {
    this.jwtUtil = jwtUtil;
    this.userService = userService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
          throws ServletException, IOException {
    // Get the Authorization header from the request
    final String authorizationHeader = request.getHeader("Authorization");

    String username = null;
    String jwtToken = null;

    // Check if the Authorization header contains a Bearer token
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        jwtToken = authorizationHeader.substring(7);  // Extract the token
        try {
            username = jwtUtil.extractUsername(jwtToken);  // Extract the username from the token
        } catch (JwtException e) {
            // Handle JWT exceptions
            System.out.println("JWT validation failed: " + e.getMessage());
        }
    }

    // If username is valid and the user is not already authenticated
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = userService.loadUserByUsername(username);
        if (jwtUtil.validateToken(jwtToken, userDetails.getUsername())) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

    // Continue the request processing
    filterChain.doFilter(request, response);
  }
}
