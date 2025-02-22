package com.project.bookmanagement.controller;

import com.project.bookmanagement.dto.AuthenticationReq;
import com.project.bookmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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
    AuthenticationManager authorizationManager;
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
}
