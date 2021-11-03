package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.Role;
import com.chris.parking_backend.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRole(RoleEnum motoristRole);
}
