package com.chris.parking_backend.service;

import com.chris.parking_backend.exception.ResourceNotFoundException;
import com.chris.parking_backend.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(long id, Vehicle vehicle) throws ResourceNotFoundException;

    void deleteVehicle(long id) throws ResourceNotFoundException;

    Vehicle getVehicleById(long id) throws ResourceNotFoundException;
}
