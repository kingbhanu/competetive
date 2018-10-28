package main.java.com.swiggy.parking.service.parking;

import main.java.com.swiggy.parking.vo.vehicle.Vehicle;

public class ParkingSlot {

    private Integer slotId;
    public Integer getSlotId() {
        return slotId;
    }

    private ParkingStatus status;
    public ParkingStatus getStatus() {
        return status;
    }
    public void setStatus(ParkingStatus status) {
        this.status = status;
    }

    private Vehicle vehicle;
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot(Integer slotId) {
        this.slotId = slotId;
        this.status = ParkingStatus.OPEN;
    }

}
