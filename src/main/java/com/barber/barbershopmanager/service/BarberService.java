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

    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(Math.toIntExact(id));
    }

    @Transactional // Make sure to annotate with @Transactional for database operations
    public Barber updateBarber(Barber updatedBarber) {
        Optional<Barber> existingBarberOptional = barberRepository.findById(Math.toIntExact(updatedBarber.getId()));

        if (existingBarberOptional.isPresent()) {
            Barber existingBarber = existingBarberOptional.get();

            // Update properties of the existing barber with the values from updatedBarber
            existingBarber.setUsername(updatedBarber.getUsername());
            // Set other properties as needed

            return barberRepository.save(existingBarber); // Save the changes
        } else {
            throw new IllegalArgumentException("Barber not found");
        }
    }
}
