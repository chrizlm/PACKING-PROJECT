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
public class BlackList {
    @Id
    @GeneratedValue
    private Long blackListId;
    private String numberPlate;
    private String comments;
}
