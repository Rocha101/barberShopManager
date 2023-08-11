package com.barber.barbershopmanager.service;

import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.repositories.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final BarberRepository barberRepository;

    @Autowired
    public LoginService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public boolean authenticate(String email, String password) {
        Barber barber = barberRepository.findByEmail(email);

        return barber != null && barber.getPassword().equals(password);
    }
}
