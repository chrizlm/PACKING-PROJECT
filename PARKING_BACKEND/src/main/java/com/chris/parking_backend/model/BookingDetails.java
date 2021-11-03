package com.chris.parking_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingDetails {
    @Id
    @GeneratedValue
    private Long bookingDetailsId;
    private String vehicleType;
    private String vehicleNumberPlate;
    private Date bookingDate;
    private Time bookingTime;

    @ManyToOne
    @JoinColumn(name = "lotId", referencedColumnName = "parkingLotId")
    private ParkingLot parkingLot;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lotId", referencedColumnName = "parkingLotId")
    private ParkingLot parkingLot;

    */
    
    /*private ParkingLot parkingLot;
    please look at procurement project
     */
}
