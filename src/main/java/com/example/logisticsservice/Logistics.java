package com.example.logisticsservice;

import java.time.LocalDateTime;

public class Logistics {

    private String orderId;
    private String fromCity;
    private String toCity;
    private String currentCity;
    private String status;
    private LocalDateTime updateTime;

    public Logistics() {}

    public Logistics(String orderId, String fromCity, String toCity, String currentCity, String status, LocalDateTime updateTime) {
        this.orderId = orderId;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.currentCity = currentCity;
        this.status = status;
        this.updateTime = updateTime;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getFromCity() { return fromCity; }
    public void setFromCity(String fromCity) { this.fromCity = fromCity; }

    public String getToCity() { return toCity; }
    public void setToCity(String toCity) { this.toCity = toCity; }

    public String getCurrentCity() { return currentCity; }
    public void setCurrentCity(String currentCity) { this.currentCity = currentCity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
}