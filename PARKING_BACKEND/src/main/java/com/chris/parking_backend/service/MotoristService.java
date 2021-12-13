package com.chris.parking_backend.service;

import com.chris.parking_backend.dtos.MotoristDto;
import com.chris.parking_backend.enumModels.VehicleType;
import com.chris.parking_backend.model.Motorist;
import com.chris.parking_backend.model.MotoristEnum;
import com.chris.parking_backend.model.User;
import com.chris.parking_backend.repository.MotoristRepo;
import com.chris.parking_backend.repository.RoleRepo;
import com.chris.parking_backend.response.MotoristResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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


    @Autowired
    UserService userService;


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

    private MotoristResponse createResponse(Motorist motorist){
        return MotoristResponse.builder()
                .motoristId(motorist.getMotoristId())
                .motoristFirstName(motorist.getMotoristFirstName())
                .motoristLastName(motorist.getMotoristLastName())
                .dateCreated(motorist.getUser().getDateCreated())
                .dateUpdated(motorist.getUser().getDateUpdated())
                .motoristEmail(motorist.getMotoristEmail())
                .motoristMobile(motorist.getMotoristMobile())
                .motoristCity(motorist.getMotoristCity())
                .motoristGender(motorist.getMotoristGender())
                .role(motorist.getUser().getRole())
                .build();
    }

    public MotoristResponse createMotorist(MotoristDto motoristDto, HttpServletRequest request){
        if(motoristRepo.existsByMotoristEmail(motoristDto.getMotoristEmail()))
            throw new DuplicateKeyException("Motorist with email " + motoristDto.getMotoristEmail() + " already exists!");

        String encodedPassword = encoder.encode(motoristDto.getMotoristPassword());
        // MotoristEnum position = motoristDto.getPosition();

        User user = User.builder()
                .username(motoristDto.getMotoristFirstName())
                .userPassword(encodedPassword)
                .role(computeRole(position))
                .build();

        Motorist motorist = Motorist.builder()
                .motoristEmail(motoristDto.getMotoristEmail())
                .motoristFirstName(motoristDto.getMotoristFirstName())
                .motoristLastName(motoristDto.getMotoristLastName())
                .motoristCity(motoristDto.getMotoristCity())
                .motoristGender(motoristDto.getMotoristGender())
                .user(user)
                .build();

        Motorist savedMotorist = motoristRepo.save(motorist);

        userService.sendEmailVerificationToken(savedMotorist.getMotoristId(), motoristDto.getMotoristEmail());

        return createResponse(savedMotorist);
    }

    public MotoristResponse getMotoristById(Long id){
        return createResponse(
                motoristRepo.findById(id).orElseThrow(() ->{
                    throw new MotoristNotFoundException(id);
                }));
    }

    public void updateMotorist(MotoristDto motoristDto, Long motoristId){
        motoristRepo.findById(motoristId).ifPresentOrElse(motorist -> {
            motorist.setMotoristEmail(motoristDto.getMotoristEmail());
            motorist.getMotoristFirstName(motoristDto.getMotoristFirstName());
            motorist.getMotoristLastName(motoristDto.getMotoristLastName());
            motorist.getUser().setUserPassword(motoristDto.getMotoristPassword());
            motoristRepo.save(motorist);
        }, () -> {
            throw new MotoristNotFoundException(motoristId);
        });
    }

}
