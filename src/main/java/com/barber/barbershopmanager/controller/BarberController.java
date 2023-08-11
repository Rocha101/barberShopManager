package com.barber.barbershopmanager.controller;

import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {
    private final BarberService barberService;

    @Autowired
    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @GetMapping
    public Iterable<Barber> getAllBarbers() {
        return barberService.getAllBarbers();
    }

    @PostMapping
    public Barber createBarber(@RequestBody Barber newBarber) {
        return barberService.createBarber(newBarber);
    }
}
