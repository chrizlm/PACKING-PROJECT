package com.chris.parking_backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristDto {

    private String motoristFirstName;

    private String motoristLastName;

    @NotNull
    @Email
    private String motoristEmail;

    @NotNull
    private String motoristCity;

    @NotNull
    private String motoristGender;

    @NotNull
    private String motoristPassword;
}
