package com.chris.parking_backend.service;

import com.chris.parking_backend.model.BookingDetails;
import com.chris.parking_backend.model.ParkingLot;
import com.chris.parking_backend.model.Vehicle;
import com.chris.parking_backend.repository.BookingDetailsRepo;
import com.chris.parking_backend.repository.ParkingLotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {



    @Autowired
    private ParkingLotRepo repo;

    @Autowired
    private BookingDetailsRepo bookingDetailsRepo;



    //get capacity of a parking lot
    public int getParkingCapacity(String parkingName){

        /*
        get item of parking lot from repo using name or id
        retrieve the number of spaces it has
         */

        ParkingLot parkingArea = repo.findParkingLotByParkingLotName(parkingName);
        return parkingArea.getTotalParkingSpaces();
    }


    //getting a list of parkinglots according to location
    public List<ParkingLot> getListOfParkingLotsInArea(String parkingLocation){
        return repo.findParkingLotsByParkingLotLocation(parkingLocation);
    }


    //get available free space
    public Long getAvailableParkingSpace(String parkingName){
        ParkingLot parkingArea = repo.findParkingLotByParkingLotName(parkingName);
        int numParkingSpace = parkingArea.getTotalParkingSpaces();
        Long availableSpaces = (numParkingSpace - getOccupiedSpace());
        return availableSpaces;
    }


    //get booked spaces
    public Long getOccupiedSpace(){
        return bookingDetailsRepo.count();
    }


    //add a booking
    public void addParkedCar(BookingDetails bookingDetails, String parkingName){
        if(getAvailableParkingSpace(parkingName) > 0){
            bookingDetailsRepo.save(bookingDetails);
        }
        else{
            System.out.println("parking lot full");
        }
    }


    //remove a booking
    public void removeParkedCar(BookingDetails bookingDetails){
        //parkedCars.remove(bookingDetails);
    }


    //retrieve list of bookings
    public List<BookingDetails> getListOfParkedCars(String parkingName){

        /*
        have to get list of parked per parking lot
        pass in parking name
        retrieve
         */
        return bookingDetailsRepo.findAll();
    }
}

