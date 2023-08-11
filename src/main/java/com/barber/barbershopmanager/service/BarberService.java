package com.barber.barbershopmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.repositories.BarberRepository;

@Service
public class BarberService {

    @Autowired
    private BarberRepository action;

    public Iterable<Barber> getAllBarbers() {
        return action.findAll();
    }

    public Barber createBarber(Barber barber) {
        Barber existingBarber = action.findByEmail(barber.getEmail());

        if (existingBarber != null) {
            throw new IllegalArgumentException("Email is already in use");
        }

        return action.save(barber);
    }
}
