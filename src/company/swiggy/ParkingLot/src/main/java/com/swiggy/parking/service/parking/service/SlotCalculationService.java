package main.java.com.swiggy.parking.service.parking.service;

import main.java.com.swiggy.parking.service.parking.ParkingException;
import main.java.com.swiggy.parking.service.parking.ParkingSlot;
import main.java.com.swiggy.parking.vo.vehicle.Type;

public interface SlotCalculationService {

    public ParkingSlot getParkingSlot(Type vehicleType, int enrtyId) throws ParkingException;

}
