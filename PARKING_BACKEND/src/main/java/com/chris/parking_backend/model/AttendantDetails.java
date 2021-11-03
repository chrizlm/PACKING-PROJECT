package com.chris.parking_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttendantDetails {
    @Id
    @GeneratedValue
    private Long attendantId;
    private String attendantFirstName;
    private String attendantLastName;
    private String attendantEmail;
    private String attendantPassword;
}
