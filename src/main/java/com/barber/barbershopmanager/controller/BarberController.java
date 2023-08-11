package com.barber.barbershopmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.repositories.BarberRepository;
import com.barber.barbershopmanager.service.BarberService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {
    private final BarberService barberService;

    @Autowired
    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @Autowired
    private BarberRepository action;

    @GetMapping
    public Iterable<Barber> getAllBarbers() {
        return barberService.getAllBarbers();
    }

    @PostMapping
    public Barber createBarber(@RequestBody Barber newBarber) {
        // Check if the email is already in use
        Barber existingBarber = action.findByEmail(newBarber.getEmail());

        if (existingBarber != null) {
            // Email is already in use, handle the situation as needed
            throw new IllegalArgumentException("Email is already in use");
        }

        // Email is not in use, create the new barber
        return action.save(newBarber);
    }
}
