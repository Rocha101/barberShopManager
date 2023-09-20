package com.barber.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.barbershop.model.Barber;
import com.barber.barbershop.repositories.BarberRepository;

import java.util.Optional;

import static java.lang.Math.toIntExact;

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
            throw new IllegalArgumentException("Email já está em uso");
        }

        return barberRepository.save(barber);
    }

    public Barber updateBarber(Barber barber) {
        Barber existingBarber = barberRepository.findByEmail(barber.getEmail());

        if (existingBarber != null) {
            throw new IllegalArgumentException("Email já está em uso");
        }

        return barberRepository.save(barber);
    }

    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(toIntExact(id));
    }

    public void removeBarber(Long id) {
        Barber barber = getBarberById(id)
                .orElseThrow(() -> new IllegalArgumentException("Barbeiro não encontrado com o id: " + id));

        barberRepository.delete(barber);
    }
}
