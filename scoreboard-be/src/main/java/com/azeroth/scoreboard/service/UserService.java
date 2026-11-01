package com.azeroth.scoreboard.service;

// import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.azeroth.scoreboard.model.User;
import com.azeroth.scoreboard.repository.UserRepository;

@Service 
public class UserService implements UserDetailsService {
  private  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // public User findUser(Integer userId) {
  //   Optional<User> optionalUser = userRepository.findById(userId);
  //   User user = optionalUser.orElseThrow(() -> new IllegalArgumentException(
  //     "Match not found with id: " + userId + ". Please ensure the ID is correct "
  //   ));
  //   return user;
  // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(username)
              .orElseThrow(() -> new UsernameNotFoundException("User not found"));

      // Build a UserDetails object using the data from user
      return org.springframework.security.core.userdetails.User.builder()
              .username(user.getUsername())
              .password(user.getPassword())
              .roles("USER")  // Assign a default role
              .build();
    }

}
