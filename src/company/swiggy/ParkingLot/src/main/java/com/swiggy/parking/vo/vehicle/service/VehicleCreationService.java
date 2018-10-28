package main.java.com.swiggy.parking.vo.vehicle.service;

import main.java.com.swiggy.parking.vo.vehicle.Car;
import main.java.com.swiggy.parking.vo.vehicle.Type;
import main.java.com.swiggy.parking.vo.vehicle.Vehicle;

public class VehicleCreationService {

    public static Vehicle create(Type type, String number, String color) {
        switch (type) {
            case CAR: return new Car(number, color);

            // TODO : throw exceptiopn
            default: return null;
        }
    }

}
