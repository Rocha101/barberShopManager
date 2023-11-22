package com.barbershop.manager.services;

import com.barbershop.manager.models.Schedule;
import com.barbershop.manager.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    public Schedule createSchedule(Map<String, Object> scheduleRequest) {
        try {
            return (Schedule) scheduleRequest;
        } catch (Exception e) {
            throw new RuntimeException("Error creating schedule: " + e.getMessage());
        }
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule updateSchedule(Long id, Schedule updatedSchedule) {
        // Implement logic to update the schedule with the provided ID using the updatedSchedule data
        // Use scheduleRepository to perform the update
        return scheduleRepository.save(updatedSchedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    // Other service methods for CRUD operations
}
