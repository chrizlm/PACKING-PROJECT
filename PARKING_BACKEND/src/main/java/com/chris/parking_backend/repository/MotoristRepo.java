package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.Motorist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristRepo extends JpaRepository<Motorist, Long> {
    Motorist findMotoristByMotoristEmail(String email);
    boolean existsByMotoristEmail(String email);
    Motorist findByUser_Username(String username);
}
