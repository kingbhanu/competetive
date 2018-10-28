package main.java.com.swiggy.parking.service.enquiry.EnquiryServiceImpl;


import main.java.com.swiggy.parking.service.parking.ParkingLot;
import main.java.com.swiggy.parking.service.parking.ParkingSlot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegistrationNumberEnquiryService {

    public List<String> findRegistrationNumbersByColor(ParkingLot parkingLot, String color) {
        Map<String, List<ParkingSlot>> colorMapping = parkingLot.getColorMapping();
        List<ParkingSlot> slots = colorMapping.get(color);
        List<String> regNumbers = new ArrayList<>(slots.size());
        Iterator<ParkingSlot> slotIterator = slots.iterator();
        while (slotIterator.hasNext()) {
            ParkingSlot slot = slotIterator.next();
            regNumbers.add(slot.getVehicle().getRegistrationNumber());
        }
        return regNumbers;
    }

}
