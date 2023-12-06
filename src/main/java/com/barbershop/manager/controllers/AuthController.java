package com.barbershop.manager.controllers;

import com.barbershop.manager.models.User;
import com.barbershop.manager.repositories.UserRepository;
import com.barbershop.manager.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        System.out.println(user);
        Optional<User> EmailAlreadyExists = userRepository.findByEmail(user.getEmail());

        if(EmailAlreadyExists.isEmpty()) {
            User newUser = userRepository.save(user);
            Map<String, Object> response = new HashMap<>();
            response.put("user", newUser);

            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Register failed"));
        }
    }

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {

            String token = tokenService.generateToken(user.getEmail());

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", existingUser.get());

            return ResponseEntity.ok(response);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Login failed"));
        }
    }


}
