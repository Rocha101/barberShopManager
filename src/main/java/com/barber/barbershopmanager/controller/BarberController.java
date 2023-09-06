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

    @PutMapping
    public Barber updateBarber(@RequestBody Barber newBarber) {
        return barberService.updateBarber(newBarber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeBarber(@PathVariable Long id) {
        Optional<Barber> barber = barberService.getBarberById(id);

        if (barber.isPresent()) {
            barberService.removeBarber(id);
            return ResponseEntity.ok("Barbeiro with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
