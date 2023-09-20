package com.barber.barbershop.service;

import com.barber.barbershop.model.Labor;
import com.barber.barbershop.repositories.LaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.Math.toIntExact;

@Service
public class LaborService {

    private final LaborRepository laborRepository;

    @Autowired
    public LaborService(LaborRepository laborRepository) {
        this.laborRepository = laborRepository;
    }

    public Iterable<Labor> getAllLabors() {
        return laborRepository.findAll();
    }

    public Labor createLabor(Labor labor) {
        Labor existingLabor = laborRepository.findByDescription(labor.getDescription());

        if (existingLabor != null) {
            throw new IllegalArgumentException("Descrição já está em uso");
        }

        return laborRepository.save(labor);
    }

    public Labor updateLabor(Labor barber) {
        Labor existingLabor = laborRepository.findByDescription(barber.getDescription());

        if (existingLabor != null) {
            throw new IllegalArgumentException("Descrição já está em uso");
        }

        return laborRepository.save(barber);
    }

    public Optional<Labor> getLaborById(Long id) {
        return laborRepository.findById(toIntExact(id));
    }

    public void removeLabor(Long id) {
        Labor labor = getLaborById(id)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o id: " + id));

        laborRepository.delete(labor);
    }
}
