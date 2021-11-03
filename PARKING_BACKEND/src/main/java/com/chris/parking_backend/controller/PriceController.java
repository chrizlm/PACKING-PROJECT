package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.PricingRates;
import com.chris.parking_backend.service.PricingRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price")
public class PriceController {
    @Autowired
    PricingRatesService service;

    @GetMapping("/details")
    ResponseEntity<?> getPricingInfo(int duration, String vehicleType){
        double response = service.calculatePrice(duration, vehicleType);
        return ResponseEntity.ok().body(response);
    }



}

 /*
    public void getPricingInfo(int duration, String vehicleType){

        @RequestBody PricingRates pricingRates
        the pricing rates include
        -vehicle type
        -duration

        service.calculatePrice(duration, vehicleType);
    }

    */