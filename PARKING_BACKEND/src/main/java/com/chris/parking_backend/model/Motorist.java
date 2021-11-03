package com.chris.parking_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Motorist {
    @Id
    @GeneratedValue
    private Long motoristId;
    private String motoristFirstName;
    private String motoristLastName;
    private String motoristEmail;
    private String motoristMobile;
    private String motoristCity;
    private String motoristGender;
    //private String motoristPassword;

    /*
    @Enumerated(value = EnumType.STRING)
    private MotoristEnum userPosition;

     */

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;
}
