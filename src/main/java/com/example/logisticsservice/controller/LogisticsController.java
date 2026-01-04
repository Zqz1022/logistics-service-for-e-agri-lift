package com.example.logisticsservice.controller;

import com.example.logisticsservice.Logistics;
import com.example.logisticsservice.LogisticsRequest;
import com.example.logisticsservice.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    @Autowired
    private LogisticsService logisticsService;

    @PostMapping
    public ResponseEntity<Logistics> createLogistics(@RequestBody LogisticsRequest request) {
        Logistics logistics = logisticsService.createLogistics(request.getFromCity(), request.getToCity());
        return ResponseEntity.ok(logistics);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Logistics> getLogistics(@PathVariable String orderId) {
        Logistics logistics = logisticsService.getAndAdvanceLogistics(orderId);
        if (logistics == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(logistics);
    }
}
