package main.java.com.swiggy.parking.service.enquiry.EnquiryServiceImpl;


import main.java.com.swiggy.parking.service.parking.ParkingLot;
import main.java.com.swiggy.parking.service.parking.ParkingSlot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SlotEnquiryService {

    public List<Integer> findSlotNumbersByColor(ParkingLot parkingLot, String color) {
        Map<String, List<ParkingSlot>> colorMapping = parkingLot.getColorMapping();
        List<ParkingSlot> slots = colorMapping.get(color);
        List<Integer> slotNumbers = new ArrayList<>(slots.size());
        Iterator<ParkingSlot> slotIterator = slots.iterator();
        while (slotIterator.hasNext()) {
            ParkingSlot slot = slotIterator.next();
            slotNumbers.add(slot.getSlotId());
        }
        return slotNumbers;
    }

    public int findSlotNumberByRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
        Map<String, ParkingSlot> registrationNumberMapping = parkingLot.getRegistrationNumberMapping();
        ParkingSlot slot = registrationNumberMapping.get(registrationNumber);
        return null == slot ? -1 : slot.getSlotId();
    }

}
