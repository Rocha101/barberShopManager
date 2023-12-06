package com.barbershop.manager.controllers;

import com.barbershop.manager.models.Location;
import com.barbershop.manager.models.Sale;
import com.barbershop.manager.models.Schedule;
import com.barbershop.manager.repositories.ScheduleRepository;
import com.barbershop.manager.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @PostMapping("/create")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Map<String, Object> scheduleRequest) {
        try {
            Schedule newSchedule = scheduleService.createSchedule(scheduleRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(newSchedule);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Schedule>> getAllSales(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Schedule> allSchedules = scheduleRepository.findAll(pageable);
        return ResponseEntity.ok(allSchedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        try {
            Schedule schedule = scheduleService.getScheduleById(id);
            return ResponseEntity.status(HttpStatus.OK).body(schedule);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        try {
            Schedule updatedSchedule = scheduleService.updateSchedule(id, schedule);
            return ResponseEntity.status(HttpStatus.OK).body(updatedSchedule);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        try {
            scheduleService.deleteSchedule(id);
            return ResponseEntity.status(HttpStatus.OK).body("Schedule deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


