package com.chris.parking_backend.service;

import com.chris.parking_backend.model.BookingDetails;
import com.chris.parking_backend.repository.BookingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingDetailsRepo repo;

    //create bookingRecord
    public BookingDetails createBookingRecord(BookingDetails bookingDetails){
       return repo.save(bookingDetails);
    }

    //finding booking record by time
    /* public BookingDetails findBookingRecordByTime(Time time){
        return repo.findByTime(time);
    }

     */

    //finding all records
    public List<BookingDetails> findAllBookingRecords(){
        return repo.findAll();
    }

    //delete a record
   /* public void deleteBookingRecord(Time time){
        BookingDetails toBeDeletedBookingDetail = repo.findByTime(time);
        repo.delete(toBeDeletedBookingDetail);
    }

    */

    public void deleteAllBookingRecords() {
        repo.deleteAll();
    }
}
