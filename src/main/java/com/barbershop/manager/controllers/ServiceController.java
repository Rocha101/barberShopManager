package com.barbershop.manager.controllers;

import com.barbershop.manager.models.Service;
import com.barbershop.manager.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/barber/{id}")
    public ResponseEntity<List<Service>> getServicesByBarberId(@PathVariable Long id) {
        List<Service> services = serviceRepository.findByUserId(id);
        return ResponseEntity.ok(services);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceRepository.findAll();
        return ResponseEntity.ok(services);
    }

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service newService = serviceRepository.save(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(newService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service updatedService) {
        if (!serviceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedService.setId(id);
        Service savedService = serviceRepository.save(updatedService);
        return ResponseEntity.ok(savedService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        if (!serviceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        serviceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
