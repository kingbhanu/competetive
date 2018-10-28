package main.java.com.swiggy.parking.vo.vehicle.service;

import main.java.com.swiggy.parking.vo.vehicle.Car;
import main.java.com.swiggy.parking.vo.vehicle.Type;
import main.java.com.swiggy.parking.vo.vehicle.Vehicle;

public class VehicleTypeService {

    public static Type getVehicleType(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return Type.CAR;
        } else {
            // default case
            // TODO : throw exception
            return null;
        }
    }

}
