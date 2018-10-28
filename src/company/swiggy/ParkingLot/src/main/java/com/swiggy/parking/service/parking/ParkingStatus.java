package main.java.com.swiggy.parking.service.parking;

public enum ParkingStatus {

    OPEN("open"),
    TAKEN("taken"),
    RESERVED("reserved");

    private String status;

    private ParkingStatus(String status) {
        this.status = status;
    }

}
