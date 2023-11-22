package com.barbershop.manager.controllers;

import com.barbershop.manager.models.Location;
import com.barbershop.manager.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/barber/{id}")
    public ResponseEntity<List<Location>> getLocationsByBarberId(@PathVariable Long id) {
        List<Location> locations = locationRepository.findByUserId(id);
        return ResponseEntity.ok(locations);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location newLocation = locationRepository.save(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLocation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location updatedLocation) {
        if (!locationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedLocation.setId(id);
        Location savedLocation = locationRepository.save(updatedLocation);
        return ResponseEntity.ok(savedLocation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        if (!locationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        locationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

