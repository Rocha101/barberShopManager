package com.barber.barbershopmanager.repositories;

import com.barber.barbershopmanager.model.Labor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaborRepository extends CrudRepository<Labor, Integer> {

    Iterable<Labor> findAll();

    Labor findByDescription(String description);

    Labor findById(Long id);
}
