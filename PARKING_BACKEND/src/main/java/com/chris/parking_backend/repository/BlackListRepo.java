package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepo extends JpaRepository<BlackList, Long> {
}
