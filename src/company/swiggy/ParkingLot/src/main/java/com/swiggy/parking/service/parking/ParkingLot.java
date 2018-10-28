package main.java.com.swiggy.parking.service.parking;

import main.java.com.swiggy.parking.service.enquiry.EnquiryService;
import main.java.com.swiggy.parking.service.parking.service.ServiceImpl.ParkingService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private List<Integer> entryPointId;
    private Integer capacity;
    private Integer entryPointCount;

    // TODO : use set
    private Map<String, List<ParkingSlot>> colorMapping;
    public Map<String, List<ParkingSlot>> getColorMapping() {
        return colorMapping;
    }

    private Map<String, ParkingSlot> registrationNumberMapping;
    public Map<String, ParkingSlot> getRegistrationNumberMapping() {
        return registrationNumberMapping;
    }

    private Map<Integer, ParkingSlot> slotMapping;
    public Map<Integer, ParkingSlot> getSlotMapping() {
        return slotMapping;
    }

    private ParkingService parkingService;
    public ParkingService getParkingService() {
        return this.parkingService;
    }

    private EnquiryService enquiryService;
    public EnquiryService getEnquiryService() {
        return this.enquiryService;
    }


    public ParkingLot(int capacity, int entryPointCount) {
        this.capacity = capacity;
        this.entryPointCount = entryPointCount;
        initMappings();
        initServices();
    }

    private void initServices() {
        this.parkingService = new ParkingService();
        this.enquiryService = new EnquiryService();
    }

    private void initMappings() {
        this.colorMapping = new ConcurrentHashMap<>();
        this.registrationNumberMapping = new ConcurrentHashMap<>();
        this.slotMapping = new ConcurrentHashMap<>();
    }


}
