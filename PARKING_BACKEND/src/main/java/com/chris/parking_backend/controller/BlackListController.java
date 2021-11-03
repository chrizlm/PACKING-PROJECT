package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.BlackList;
import com.chris.parking_backend.repository.BlackListRepo;
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
@RequestMapping("/api/blacklist")
public class BlackListController {
    @Autowired
    private BlackListRepo repo;
    private final Logger log = LoggerFactory.getLogger(BookingController.class);

    //create a blacklist
    @PostMapping("/create")
    ResponseEntity<BlackList> createBlacklist(@RequestBody BlackList blackList) throws URISyntaxException {
        log.info("Request to create blacklist:{}", blackList);
        BlackList newBlackList = repo.save(blackList);
        return ResponseEntity.created(new URI("/api/blacklist/create" + newBlackList.getBlackListId()))
                .body(newBlackList);
    }

    //update blacklist
    @PutMapping("/update")
    ResponseEntity<BlackList> updateBlacklist(@RequestBody BlackList blackList){
        log.info("Request to update blacklist:{}", blackList);
        BlackList newBlackList = repo.save(blackList);
        return ResponseEntity.ok().body(newBlackList);
    }

    //get blacklist
    @GetMapping("/{blackListId}")
    ResponseEntity<?> getBlackList(@PathVariable Long blackListId){
        Optional<BlackList> foundBlackList = repo.findById(blackListId);
        return foundBlackList.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //get a list of all blacklist
    @GetMapping("/all")
    public List<BlackList> getAllBlacklist(){
        return repo.findAll();
    }

    //delete blacklist
    @DeleteMapping("/{blackListId}")
    ResponseEntity<?> removeBlacklist(@PathVariable Long blackListId){
        log.info("Request to delete blacklist:{}", blackListId);
        repo.deleteById(blackListId);
        return ResponseEntity.ok().build();
    }

    //delete all blacklist
    @DeleteMapping("/removeAll")
    public void removeAllBlacklist(){
        repo.deleteAll();
    }
}
