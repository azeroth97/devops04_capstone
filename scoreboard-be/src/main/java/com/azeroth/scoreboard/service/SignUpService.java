package com.azeroth.scoreboard.service;

import com.azeroth.scoreboard.model.User;
import com.azeroth.scoreboard.repository.UserRepository;
import com.azeroth.scoreboard.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private JwtUtil jwtUtil;

  public SignUpService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
  }

  public String signUpUser(String username, String password) {
    // Check if username already exists
    if (userRepository.findByUsername(username).isPresent()) {
      return "Error: Username already exists!";
    }

    // Encrypt the password
    String encryptedPassword = passwordEncoder.encode(password);

    // Save the user to the database
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(encryptedPassword);
    userRepository.save(newUser);

    // Generate JWT token
    String token = jwtUtil.generateToken(username);

    return token;
  }
}
