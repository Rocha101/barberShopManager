package com.barber.barbershopmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class SystemHealthController {
    @GetMapping
    public Boolean getSystemHealth(){
        return true;
    }
}
