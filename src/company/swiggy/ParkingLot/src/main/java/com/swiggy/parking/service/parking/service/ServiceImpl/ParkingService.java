package main.java.com.swiggy.parking.service.parking.service.ServiceImpl;

import main.java.com.swiggy.parking.service.parking.ParkingLot;
import main.java.com.swiggy.parking.service.parking.ParkingSlot;
import main.java.com.swiggy.parking.service.parking.ParkingStatus;
import main.java.com.swiggy.parking.service.parking.service.SlotCalculationService;
import main.java.com.swiggy.parking.vo.vehicle.service.VehicleTypeService;
import main.java.com.swiggy.parking.vo.vehicle.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingService {

    private SlotCalculationService slotCalculationService;

    public ParkingService() {
        initServices();
    }

    private void initServices() {
        this.slotCalculationService = new NearestSlotCalculationService();
    }

    public ParkingSlot park(ParkingLot parkingLot, Vehicle vehicle, int entryId) {
        ParkingSlot parkingSlot = null;
        parkingSlot = slotCalculationService.getParkingSlot(VehicleTypeService.getVehicleType(vehicle), entryId);
        makeEntry(parkingLot, vehicle, parkingSlot);
        return parkingSlot;
    }

    public void leave(ParkingLot parkingLot, int slotId) {
        ParkingSlot parkingSlot = parkingLot.getSlotMapping().get(slotId);
        removeEntry(parkingLot, parkingSlot);
    }

    // opp of make entry
    // just like destructor
    private void removeEntry(ParkingLot parkingLot, ParkingSlot parkingSlot) {
        removeRegistrationEntry(parkingLot, parkingSlot);
        removeColorEntry(parkingLot, parkingSlot);
        removeSlotEntry(parkingLot, parkingSlot);
        parkingSlot.setVehicle(null);
        parkingSlot.setStatus(ParkingStatus.OPEN);
    }

    private void removeRegistrationEntry(ParkingLot parkingLot, ParkingSlot parkingSlot) {
        Map<String, ParkingSlot> registrationNumberMapping = parkingLot.getRegistrationNumberMapping();
        registrationNumberMapping.remove(parkingSlot.getVehicle().getRegistrationNumber());
    }

    private void removeColorEntry(ParkingLot parkingLot, ParkingSlot parkingSlot) {
        Map<String, List<ParkingSlot>> colorMapping = parkingLot.getColorMapping();
        List<ParkingSlot> vehicles = colorMapping.get(parkingSlot.getVehicle().getColor());
        Iterator<ParkingSlot> slots = vehicles.iterator();
        while (slots.hasNext()) {
            ParkingSlot slot = slots.next();
            if (slot.equals(parkingSlot)) {
                slots.remove();
            }
        }
    }

    private void removeSlotEntry(ParkingLot parkingLot, ParkingSlot parkingSlot) {
        Map<Integer, ParkingSlot> slotMapping = parkingLot.getSlotMapping();
        slotMapping.remove(parkingSlot.getSlotId());
    }

    private void makeEntry(ParkingLot parkingLot, Vehicle vehicle, ParkingSlot parkingSlot) {
        parkingSlot.setStatus(ParkingStatus.TAKEN);
        parkingSlot.setVehicle(vehicle);
        makeSlotEntry(parkingLot, vehicle, parkingSlot);
        makeColorEntry(parkingLot, vehicle, parkingSlot);
        makeRegistrationEntry(parkingLot, vehicle, parkingSlot);
    }

    private void makeSlotEntry(ParkingLot parkingLot, Vehicle vehicle, ParkingSlot parkingSlot) {
        Map<Integer, ParkingSlot> slotMapping = parkingLot.getSlotMapping();
        slotMapping.put(parkingSlot.getSlotId(), parkingSlot);
    }

    private void makeColorEntry(ParkingLot parkingLot, Vehicle vehicle, ParkingSlot parkingSlot) {
        List<ParkingSlot> vehicles = null;
        Map<String, List<ParkingSlot>> colorMapping = parkingLot.getColorMapping();
        if (colorMapping.containsKey(vehicle.getColor())) {
            vehicles = colorMapping.get(vehicle.getColor());
            vehicles.add(parkingSlot);
        } else {
            vehicles = new LinkedList<>();
            vehicles.add(parkingSlot);
        }
    }

    private void makeRegistrationEntry(ParkingLot parkingLot, Vehicle vehicle, ParkingSlot parkingSlot) {
        Map<String, ParkingSlot> registrationNumberMapping = parkingLot.getRegistrationNumberMapping();
        registrationNumberMapping.put(vehicle.getRegistrationNumber(), parkingSlot);
    }

    public List<String> getStatus(ParkingLot parkingLot) {

        return null;
    }

}
