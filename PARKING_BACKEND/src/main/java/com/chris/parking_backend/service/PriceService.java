package com.chris.parking_backend.service;

import com.chris.parking_backend.enumModels.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    //private VehicleType vehicleType;
    //private int hours;


    public void calculate_Price(VehicleType vehicleType, int hours){
        switch (vehicleType){
            case PSV: psvPrice(hours);break;
            case TRUCK: truckPrice(hours);break;
            case SALOON: saloonPrice(hours);break;
            case TRAILER: trailerPrice(hours);break;
            default:System.out.println("no option selected");
        }
    }

    public double psvPrice(int hours){
        return 100 * hours;
    }

    public double truckPrice(int hours){
        return 150 * hours;
    }

    public double saloonPrice(int hours){
        return 50 * hours;
    }

    public double trailerPrice(int hours){
        return 200 * hours;
    }
}
