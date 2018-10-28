package main.java.com.swiggy.parking.service.parking.service.ServiceImpl;

import main.java.com.swiggy.parking.service.parking.ParkingException;
import main.java.com.swiggy.parking.service.parking.ParkingSlot;
import main.java.com.swiggy.parking.service.parking.service.SlotCalculationService;
import main.java.com.swiggy.parking.vo.vehicle.Type;

import java.util.Random;

public class NearestSlotCalculationService implements SlotCalculationService {

    // mock slot calculation using random
    Random random;

    public NearestSlotCalculationService() {
        random = new Random();
    }

    @Override
    public ParkingSlot getParkingSlot(Type vehicleType, int entryId) throws ParkingException {
        return new ParkingSlot();
    }
}
