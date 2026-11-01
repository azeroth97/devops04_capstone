package com.azeroth.scoreboard.controller;

import com.azeroth.scoreboard.dto.AuthRequestDTO;
import com.azeroth.scoreboard.dto.SignUpRequestDTO;
import com.azeroth.scoreboard.security.JwtUtil;
import com.azeroth.scoreboard.service.SignUpService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
  private JwtUtil jwtUtil;
  private AuthenticationManager authenticationManager;
  private SignUpService signUpService;

  public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, SignUpService signUpService) {
    this.jwtUtil = jwtUtil;
    this.authenticationManager = authenticationManager;
    this.signUpService = signUpService;
  }

  @PostMapping("/signup")
  public String signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
    // Extract username and password from DTO and call the service
    String username = signUpRequestDTO.getUsername();
    String password = signUpRequestDTO.getPassword();

    return signUpService.signUpUser(username, password);
  }

  @PostMapping("/login")
  public String login(@RequestBody AuthRequestDTO authRequestDTO) throws AuthenticationException {
    String username = authRequestDTO.getUsername();
    String password = authRequestDTO.getPassword();

    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(username, password)
    );

    if (authentication.isAuthenticated()) {
      // Generate JWT token
      return jwtUtil.generateToken(username);
    } else {
      throw new BadCredentialsException("Invalid credentials");
    }
  }

  // New /home endpoint that requires authentication
  @GetMapping("/home")
  public String home() {
    return "Welcome to the home page! You are authenticated.";
  }
}
