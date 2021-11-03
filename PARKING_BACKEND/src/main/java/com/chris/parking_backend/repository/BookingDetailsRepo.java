package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;

@Repository
public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Long> {
}
