package main.java.com.swiggy.parking.vo.vehicle;

public abstract class Vehicle {

    private String registrationNumber;
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    private String color;
    public String getColor() {
        return color;
    }

    public Vehicle(String registrationNumber, String color) {
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

}
