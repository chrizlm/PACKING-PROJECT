package com.chris.parking_backend.service;

import com.chris.parking_backend.model.ParkingLot;
import com.chris.parking_backend.repository.ParkingLotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {
    @Autowired
    ParkingLotRepo repo;

    //create parking lot
    public void createParkingLot(ParkingLot parkingLot){
        repo.save(parkingLot);
    }

    //find parking Lot by name
     public ParkingLot findParkingLotByName(String parkingLotName){
        return repo.findParkingLotByParkingLotName(parkingLotName);
        //return repo.findByName(parkingLotName);
    }



    //find parking Lot by location
    public ParkingLot findParkingLotByLocation(String parkingLotLocation){
        return repo.findParkingLotByParkingLotLocation(parkingLotLocation);
       //return repo.findByLocation(parkingLotLocation);
    }



    //find all parking lot
    public List<ParkingLot> findAllParkingLots(){
        return repo.findAll();
    }

    //find all parking lots using location
    public List<ParkingLot> findAllParkingLotsByLocationProvided(String location){
        return repo.findParkingLotsByParkingLotLocation(location);
    }

    //delete a parking lot using name
     public void deleteParkingLot(String parkingLotName){
        repo.deleteParkingLotByParkingLotName(parkingLotName);
        //repo.deleteByName(parkingLotName);
    }



    //delete all parking lots
    public void deleteAllParkingLots(){
        repo.deleteAll();
    }


}
