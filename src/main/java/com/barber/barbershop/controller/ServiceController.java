package com.barber.barbershop.controller;

import com.barber.barbershop.model.Labor;
import com.barber.barbershop.service.LaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/labor")
public class LaborController {
    private final LaborService laborService;

    @Autowired
    public LaborController(LaborService laborService) {
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
