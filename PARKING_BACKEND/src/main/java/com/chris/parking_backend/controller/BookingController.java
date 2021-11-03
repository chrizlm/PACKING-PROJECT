package com.chris.parking_backend.controller;

import com.chris.parking_backend.model.BookingDetails;
import com.chris.parking_backend.repository.BookingDetailsRepo;
import com.chris.parking_backend.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.List;


@RestController
@RequestMapping("/api/booking")
public class BookingController {

   @Autowired
   private BookingService service;
    private final Logger log = (Logger) LoggerFactory.getLogger(BookingController.class);

    //create booking record
    @PostMapping("/details")
    ResponseEntity<BookingDetails> createBookingRecord(@RequestBody BookingDetails bookingDetails) throws URISyntaxException {
        log.info("Request to create a booking record : {}", bookingDetails);
        BookingDetails newBookingDetails = service.createBookingRecord(bookingDetails);
        return ResponseEntity.created(new URI("/api/booking/details" + newBookingDetails.getBookingDetailsId()))
                .body(newBookingDetails);
    }

    //update record
    @PutMapping("/update")
    ResponseEntity<BookingDetails> updateBookingRecord(@RequestBody BookingDetails bookingDetails){
        log.info("Request to update booking record : {}", bookingDetails);
        BookingDetails updatedBookingDetails = service.createBookingRecord(bookingDetails);
        return ResponseEntity.ok().body(updatedBookingDetails);
    }

    //getting a record according to time
   /* @GetMapping("/{time}")
    ResponseEntity<BookingDetails> getBookingRecordByTime(@PathVariable Time time){
        BookingDetails foundBookingDetails = service.findBookingRecordByTime(time);
        return ResponseEntity.ok().body(foundBookingDetails);
    }

    */

    //get all records
    @GetMapping("/all")
    public List<BookingDetails> getAllBookingRecords(){
        return service.findAllBookingRecords();
    }

    //delete a record
    /* @DeleteMapping("/{time}")
    ResponseEntity<?> removeBookingRecord(@PathVariable Time time){
        log.info("Request to delete booking record : {}", time);
        service.deleteBookingRecord(time);
        return ResponseEntity.ok().build();
    }
    
     */

    //delete all records
    @DeleteMapping("/removeAll")
    public void removeAllBookingRecords(){
        service.deleteAllBookingRecords();
    }
}
