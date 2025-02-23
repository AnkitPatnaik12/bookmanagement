package com.project.bookmanagement.controller;

import com.project.bookmanagement.dto.AuthenticationReq;
import com.project.bookmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.bookmanagement.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class UserAuthenticationController {
    @Autowired
    AuthenticationManager authenticateManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String registerUser(@RequestBody AuthenticationReq authRequest) {
        if (userRepository.findByUsername(authRequest.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists!");
        }

        User newUser = new User();
        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        userRepository.save(newUser);
        return "User registered successfully!";
    }
    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthenticationReq authRequest) {
        Authentication authentication = authenticateManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return "logged in";
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
