package com.barbershop.manager.repositories;

import com.barbershop.manager.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findById();
    // You can add custom query methods here if needed
}
