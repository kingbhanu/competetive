package main.java.com.swiggy.parking.service.enquiry;

import main.java.com.swiggy.parking.service.enquiry.EnquiryServiceImpl.RegistrationNumberEnquiryService;
import main.java.com.swiggy.parking.service.enquiry.EnquiryServiceImpl.SlotEnquiryService;
import main.java.com.swiggy.parking.service.parking.ParkingLot;

import java.util.List;

public class EnquiryService {

    private RegistrationNumberEnquiryService registrationNumberEnquiryService;
    private SlotEnquiryService slotEnquiryService;

    public EnquiryService() {
        this.registrationNumberEnquiryService = new RegistrationNumberEnquiryService();
        this.slotEnquiryService = new SlotEnquiryService();
    }

    public List<String> findRegistrationNumbersByColor(ParkingLot parkingLot, String color) {
        return this.registrationNumberEnquiryService.findRegistrationNumbersByColor(parkingLot, color);
    }

    public List<Integer> findSlotNumbersByColor(ParkingLot parkingLot, String color) {
        return this.slotEnquiryService.findSlotNumbersByColor(parkingLot, color);
    }

    public int findSlotNumberByRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
        return this.slotEnquiryService.findSlotNumberByRegistrationNumber(parkingLot, registrationNumber);
    }

}
