package com.chris.parking_backend.service;

import com.chris.parking_backend.enumModels.VehicleType;
import com.chris.parking_backend.repository.MotoristRepo;
import com.chris.parking_backend.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MotoristService {
   /* private VehicleType vehicleType;
    private int hours;
    */

    private final MotoristRepo motoristRepo;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleRepo roleRepo;

    /*
    @Autowired
    UserService userService;
     */

    /*
    get all motorist
     */

    public List<MotoristResponse> getAllMotorists(){
        List<MotoristResponse> responseList = new ArrayList<>();
        motoristRepo.findAll().forEach(motorist -> {
            responseList.add(createResponse(motorist));
        });
        return responseList;
    }

}
