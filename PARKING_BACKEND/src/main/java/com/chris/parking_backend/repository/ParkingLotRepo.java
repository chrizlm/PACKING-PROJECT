package com.chris.parking_backend.repository;

import com.chris.parking_backend.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepo extends JpaRepository<ParkingLot, Long> {
    ParkingLot findParkingLotByParkingLotName(String parkingLotName);
    ParkingLot findParkingLotByParkingLotLocation(String parkingLotLocation);
    void deleteParkingLotByParkingLotName(String parkingLotName);
    List<ParkingLot> findParkingLotsByParkingLotLocation(String parkingLotLocation);

  /*  public ParkingLot findByName(final String parkingLotName);

    public ParkingLot findByLocation(final String parkingLotLocation);

    void deleteByName(final String parkingLotName);

   */
}
