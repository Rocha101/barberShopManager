package com.barbershop.manager.repositories;

import com.barbershop.manager.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // You can add custom query methods here if needed
}
