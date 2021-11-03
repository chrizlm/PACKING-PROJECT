package com.chris.parking_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingLotId;
    private String parkingLotLocation;
    private String parkingLotName;
    private int totalParkingSpaces;


    @OneToMany(mappedBy = "parkingLot")
    private List<BookingDetails> bookingDetails;

    /* private int regularSpaces;
    private int vipSpace;
    private int specialSpace;



     */



}
