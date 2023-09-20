package com.barber.barbershop.repositories;

import com.barber.barbershop.model.Labor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaborRepository extends CrudRepository<Labor, Integer> {

    Iterable<Labor> findAll();

    Labor findByDescription(String description);

    Labor findById(Long id);
}
