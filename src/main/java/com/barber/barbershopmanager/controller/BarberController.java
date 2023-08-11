package com.barber.barbershopmanager.controller;

import com.barber.barbershopmanager.model.Barber;
import com.barber.barbershopmanager.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getBarberById(@PathVariable Long id) {
        Optional<Barber> barber = barberService.getBarberById(id);

        return barber.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable Long id, @RequestBody Barber updatedBarber) {
        Optional<Barber> existingBarber = barberService.getBarberById(id);

        if (existingBarber.isPresent()) {
            Barber barber = existingBarber.get();
            barber.setUsername(updatedBarber.getUsername());


            Barber savedBarber = barberService.updateBarber(barber);
            return ResponseEntity.ok(savedBarber);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
