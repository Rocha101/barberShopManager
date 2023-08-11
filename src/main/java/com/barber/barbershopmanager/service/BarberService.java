package com.barber.barbershopmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.repositories.BarberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BarberService {

    private final BarberRepository barberRepository;

    @Autowired
    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public Iterable<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    public Barber createBarber(Barber barber) {
        Barber existingBarber = barberRepository.findByEmail(barber.getEmail());

        if (existingBarber != null) {
            throw new IllegalArgumentException("Email is already in use");
        }

        return barberRepository.save(barber);
    }

    public Barber updateBarber(Barber barber) {
        Barber existingBarber = barberRepository.findByEmail(barber.getEmail());

        if (existingBarber != null) {
            throw new IllegalArgumentException("Email is already in use");
        }

        return barberRepository.save(barber);
    }

    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(Math.toIntExact(id));
    }

}
