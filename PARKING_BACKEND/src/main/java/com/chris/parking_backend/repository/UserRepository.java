package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
Optional<User> findByEmailVerificationToken(String emailVerificationToken);
Optional<User> findByChangePasswordToken(String changePasswordToken);
boolean exitsByChangePasswordToken(String token);
}
