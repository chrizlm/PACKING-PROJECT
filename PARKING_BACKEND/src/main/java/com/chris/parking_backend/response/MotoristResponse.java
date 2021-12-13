package com.chris.parking_backend.response;

import com.chris.parking_backend.model.Role;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
public class MotoristResponse {
    private Long motoristId;
    private String motoristFirstName;
    private String motoristLastName;
    private String motoristEmail;
    private String motoristMobile;
    private String motoristCity;
    private String motoristGender;
    private Date dateCreated;
    private Date dateUpdated;
    private Role role;
}
