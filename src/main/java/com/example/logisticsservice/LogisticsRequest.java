package com.example.logisticsservice;

public class LogisticsRequest {

    private String fromCity;
    private String toCity;

    public LogisticsRequest() {}

    public LogisticsRequest(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getFromCity() { return fromCity; }
    public void setFromCity(String fromCity) { this.fromCity = fromCity; }

    public String getToCity() { return toCity; }
    public void setToCity(String toCity) { this.toCity = toCity; }
}