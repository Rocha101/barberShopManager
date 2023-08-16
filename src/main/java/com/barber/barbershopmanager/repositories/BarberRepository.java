package com.barber.barbershopmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barber.barbershopmanager.model.Barber;

import java.util.Optional;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Integer> {

    Iterable<Barber> findAll();

    Barber findByEmail(String email);

    Barber findById(Long id);
}
