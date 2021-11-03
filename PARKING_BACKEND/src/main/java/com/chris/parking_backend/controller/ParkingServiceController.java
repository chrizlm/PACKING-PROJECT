package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.BookingDetails;
import com.chris.parking_backend.model.ParkingLot;
import com.chris.parking_backend.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingService")
public class ParkingServiceController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/free/{parkingName}")
    public Long getFreeSpace(@PathVariable String parkingName){
        return parkingService.getAvailableParkingSpace(parkingName);
    }

    @GetMapping("/parkingLots/{parkingLocation}")
    public List<ParkingLot> getParkingLotsInLocation(@PathVariable String parkingLocation){
        return parkingService.getListOfParkingLotsInArea(parkingLocation);
    }

    @GetMapping("/parkingCapacity/{parkingName}")
    public int getParkingLotCapacity(@PathVariable String parkingName){
        return parkingService.getParkingCapacity(parkingName);
    }

    @PostMapping("/park/{parkingName}")
    public void parkCar(@RequestBody BookingDetails bookingDetails, @PathVariable String parkingName){
        parkingService.addParkedCar(bookingDetails, parkingName);
    }



}
