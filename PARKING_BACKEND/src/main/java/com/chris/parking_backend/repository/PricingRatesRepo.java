package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.PricingRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRatesRepo extends JpaRepository<PricingRates, Long> {
    PricingRates getByVehicleType(String vehicleType);
}
