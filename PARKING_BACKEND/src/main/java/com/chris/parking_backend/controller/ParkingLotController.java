package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.ParkingLot;
import com.chris.parking_backend.repository.ParkingLotRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parkingLot")
public class ParkingLotController {
    @Autowired
    private ParkingLotRepo repo;
    private final Logger log = LoggerFactory.getLogger(ParkingLotController.class);

    //create parking lot
    @PostMapping("/create")
    ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLot parkingLot) throws URISyntaxException {
        log.info("Request to create parking lot : {}", parkingLot);
        ParkingLot newParkingLot = repo.save(parkingLot);
        return ResponseEntity.created(new URI("/api/parkingLot/create" + newParkingLot.getParkingLotId()))
                .body(newParkingLot);
    }

    //update parking lot
    @PutMapping("/update")
    ResponseEntity<ParkingLot> updateParkingLot(@RequestBody ParkingLot parkingLot){
        log.info("Request to update paörking lot : {}", parkingLot);
        ParkingLot updateParkingLot = repo.save(parkingLot);
        return ResponseEntity.ok().body(updateParkingLot);
    }

    //get parking lot
    @GetMapping("/{parkingLotId}")
    ResponseEntity<?> getParkingLot(@PathVariable Long parkingLotId){
        Optional<ParkingLot> foundParkingLot = repo.findById(parkingLotId);
        return foundParkingLot.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //get a list of all parking lot
    @GetMapping("/all")
    public List<ParkingLot> getAllParkingLot(){
       return repo.findAll();
    }

    //Delete a parking lot
    @DeleteMapping("/{parkingLotId}")
    ResponseEntity<?> removeParkingLot(@PathVariable Long parkingLotId){
        log.info("Request to delete a parking lot:{}", parkingLotId);
        repo.deleteById(parkingLotId);
        return ResponseEntity.ok().build();
    }

    //delete all parking lots
    @DeleteMapping("/removeAll")
    public void removeAllParking(){
        repo.deleteAll();
    }
}
