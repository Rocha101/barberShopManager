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
        return action.save(barber);
    }
}
