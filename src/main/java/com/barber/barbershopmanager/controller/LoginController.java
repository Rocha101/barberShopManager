package com.barber.barbershopmanager.controller;

import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.model.LoginRequest;
import com.barber.barbershopmanager.repositories.BarberRepository;
import com.barber.barbershopmanager.service.BarberService;
import com.barber.barbershopmanager.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/api")
public class LoginController {

    private final BarberRepository barberRepository;

    // Load the RSA key pair
    private final KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

    @Autowired
    public LoginController(LoginService loginService, BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Perform authentication logic here
            Barber barber = barberRepository.findByEmail(loginRequest.getEmail());

            if (barber != null && barber.getPassword().equals(loginRequest.getPassword())) {
                // Authentication successful, generate JWT token
                String token = generateJwtToken(barber.getId()); // Customize this based on your needs

                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                return response;
            } else {
                throw new Exception("Invalid credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Authentication failed");
        }
    }

    private String generateJwtToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000); // Token valid for 1 hour

        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(keyPair.getPrivate()) // Use the private key for signing
                .compact();
    }
}
