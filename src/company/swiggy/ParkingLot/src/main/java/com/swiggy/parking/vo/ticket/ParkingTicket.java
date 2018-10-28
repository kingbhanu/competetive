package main.java.com.swiggy.parking.vo.ticket;

import main.java.com.swiggy.parking.vo.vehicle.Vehicle;

public class ParkingTicket {

    private Vehicle vehicle;
    private Integer entryId;
    private Long entryTime;
    private Long exitTime;

    private Float basePrice;
    private Float additionalPrice;

    private TicketType ticketType;

}
