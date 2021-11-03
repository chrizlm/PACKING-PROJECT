package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.AttendantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendantsDetailsRepo extends JpaRepository<AttendantDetails, Long> {
}
