package com.example.logisticsservice.service;

import com.example.logisticsservice.Logistics;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LogisticsService {

    private final Map<String, Logistics> logisticsMap = new ConcurrentHashMap<>();

    public Logistics createLogistics(String fromCity, String toCity) {
        String orderId = java.util.UUID.randomUUID().toString();
        String currentCity = fromCity;
        String status = "CREATED";
        LocalDateTime updateTime = LocalDateTime.now();
        Logistics logistics = new Logistics(orderId, fromCity, toCity, currentCity, status, updateTime);
        logisticsMap.put(orderId, logistics);
        return logistics;
    }

    public Logistics getAndAdvanceLogistics(String orderId) {
        Logistics logistics = logisticsMap.get(orderId);
        if (logistics == null) {
            return null;
        }
        // Advance status
        String currentStatus = logistics.getStatus();
        if ("CREATED".equals(currentStatus)) {
            logistics.setStatus("IN_TRANSIT");
            logistics.setCurrentCity(logistics.getToCity()); // 简单假设直接到 toCity
        } else if ("IN_TRANSIT".equals(currentStatus)) {
            logistics.setStatus("DELIVERED");
        }
        // Update time
        logistics.setUpdateTime(LocalDateTime.now());
        return logistics;
    }
}