package com.barber.barbershopmanager.controller;

import com.barber.barbershopmanager.model.Labor;
import com.barber.barbershopmanager.service.LaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    private final LaborService laborService;

    @Autowired
    public ServiceController(LaborService laborService) {
        this.laborService = laborService;
    }

    @GetMapping
    public Iterable<Labor> getAllLabors() {
        return laborService.getAllLabors();
    }

    @PostMapping
    public Labor createLabor(@RequestBody Labor newLabor) {
        return laborService.createLabor(newLabor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Labor> getLaborById(@PathVariable Long id) {
        Optional<Labor> labor = laborService.getLaborById(id);

        return labor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public Labor updateLabor(@RequestBody Labor newLabor) {
        return laborService.updateLabor(newLabor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeLabor(@PathVariable Long id) {
        Optional<Labor> barber = laborService.getLaborById(id);

        if (barber.isPresent()) {
            laborService.removeLabor(id);
            return ResponseEntity.ok("Serviço com o ID " + id + " foi deletado!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
