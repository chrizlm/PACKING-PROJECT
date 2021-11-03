package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.Motorist;
import com.chris.parking_backend.repository.MotoristRepo;
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

// @CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/motorist")
public class MotoristController {

    @Autowired
    private MotoristRepo repo;
    private final Logger log = LoggerFactory.getLogger(MotoristController.class);

    //create a motorist object
    @PostMapping("/create")
    ResponseEntity<Motorist> createMotorist(@RequestBody Motorist motorist) throws URISyntaxException {
        log.info("Request to create motorist: {}", motorist);
        Motorist motorist1 = repo.save(motorist);
        return ResponseEntity.created(new URI("/api/motorist/create" + motorist1.getMotoristId()))
                .body(motorist1);
    }

    //update motorist
    @PutMapping("/update/{motoristId}")
    ResponseEntity<Motorist> updateMotorist(@RequestBody Motorist motorist){
        log.info("Request to update motorist: {}",motorist);
        Motorist motorist1 = repo.save(motorist);
        return ResponseEntity.ok().body(motorist1);
    }

    //get motorist
    @GetMapping("/{motoristId}")
    ResponseEntity<?> getMotorist(@PathVariable Long motoristId){
        Optional<Motorist> motorist = repo.findById(motoristId);
        return motorist.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //get a list of all motorist
    @GetMapping("/all")
    public List<Motorist> getAllMotorist(){
        return repo.findAll();
    }

    //delete a motorist
    @DeleteMapping("/{motoristId}")
    ResponseEntity<?> removeMotorist(@PathVariable Long motoristId){
        log.info("Request to delete motorist:{}", motoristId);
        repo.deleteById(motoristId);
        return ResponseEntity.ok().build();
    }

    //delete all motorist
    @DeleteMapping("/removeAll")
    public void removeAllMotorists(){
        repo.deleteAll();
    }
}
