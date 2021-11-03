package com.chris.parking_backend.dtos;

import lombok.Data;

@Data
public class VehicleDTO {
    private long id;
    private String title;
    private String description;
    private String content;
}
