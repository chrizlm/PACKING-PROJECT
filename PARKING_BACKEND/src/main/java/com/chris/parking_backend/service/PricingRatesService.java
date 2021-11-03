package com.chris.parking_backend.service;

import com.chris.parking_backend.model.PricingRates;
import com.chris.parking_backend.repository.PricingRatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingRatesService {
    @Autowired
    PricingRatesRepo repo;

    //setPricePerHour
    public void setPricePerHour(String vehicleType, double pricePerHour){
        PricingRates newPricingRates = new PricingRates(vehicleType, pricePerHour);
        //if it dont work use set methods
        /*
        newPricingRates.setVehicleType(vehicleType);
        newPricingRates.setPricePerHour(pricePerHour);
         */
        repo.save(newPricingRates);
    }


    //getPricePerHour
    public double getPricePerHour(String vehicleType){
        PricingRates foundVehicle = repo.getByVehicleType(vehicleType);
       double pricePerHour =  foundVehicle.getPricePerHour();
       return pricePerHour;
    }

    //updatePricePerHour
    public void updatePricePerHour(String vehicleType, double pricePerHour){
        PricingRates updateVehicle = repo.getByVehicleType(vehicleType);
        updateVehicle.setPricePerHour(pricePerHour);
        repo.save(updateVehicle);
    }

    //calculate price for given duration
    public double calculatePrice(int duration, String vehicleType){
        double newPriceCalculated = getPricePerHour(vehicleType) * duration;
        return newPriceCalculated;
    }
}
