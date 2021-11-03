package com.chris.parking_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PricingRates {
    @Id
    @GeneratedValue
    private Long priceRateId;
    private String vehicleType;
    private double pricePerHour;


    public PricingRates(String vehicleType, double pricePerHour) {
    }
}
