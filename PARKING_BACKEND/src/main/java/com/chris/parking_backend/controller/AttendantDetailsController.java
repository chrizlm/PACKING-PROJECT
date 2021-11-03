package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.AttendantDetails;
import com.chris.parking_backend.repository.AttendantsDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendant")
public class AttendantDetailsController {
    @Autowired
    private AttendantsDetailsRepo repo;
    private final Logger log = LoggerFactory.getLogger(AttendantDetailsController.class);

    //create an attendant
    @PostMapping("/create")
    ResponseEntity<AttendantDetails> createAttendant(@RequestBody AttendantDetails attendantDetails) throws URISyntaxException {
        log.info("Request to create attendant: {}", attendantDetails);
        AttendantDetails newAttendantDetails = repo.save(attendantDetails);
        return ResponseEntity.created(new URI("/api/attendant/create" + newAttendantDetails.getAttendantId()))
                .body(newAttendantDetails);
    }

    //update attendant
    @PutMapping("/update/{attendantId}")
    ResponseEntity<AttendantDetails> updateAttendant(@RequestBody AttendantDetails attendantDetails){
        log.info("Request to update attendant:{}", attendantDetails);
        AttendantDetails updateAttendantDetails = repo.save(attendantDetails);
        return ResponseEntity.ok().body(updateAttendantDetails);
    }

    //get attendant
    @GetMapping("/{attendantId}")
    ResponseEntity<?> getAttendant(@PathVariable Long attendantId){
        Optional<AttendantDetails> foundAttendantDetails = repo.findById(attendantId);
        return foundAttendantDetails.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //get all Attendants
    @GetMapping("/all")
    public List<AttendantDetails> getAllAttendants(){
        return  repo.findAll();
    }

    //delete an attendant
    @DeleteMapping("/{attendantId}")
    ResponseEntity<?> removeAttendant(@PathVariable Long attendantId){
        log.info("Requst to delete an attendant:{}", attendantId);
        repo.deleteById(attendantId);
        return ResponseEntity.ok().build();
    }

    //delete all attendants
    @DeleteMapping("/removeAll")
    public void removeAllAttendants(){
        repo.deleteAll();
    }
}
