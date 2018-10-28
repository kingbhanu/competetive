package main.java.com.swiggy.parking;

import main.java.com.swiggy.parking.service.parking.ParkingException;
import main.java.com.swiggy.parking.service.parking.ParkingLot;
import main.java.com.swiggy.parking.service.parking.ParkingSlot;
import main.java.com.swiggy.parking.vo.vehicle.Type;
import main.java.com.swiggy.parking.vo.vehicle.Vehicle;
import main.java.com.swiggy.parking.vo.vehicle.service.VehicleCreationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ParkingApplication {

    public static ParkingLot swiggyParkingLot;


    public static void main(String args[]) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String[] input = br.readLine().split(GlobalConstants.SPACE);
                String number = null;
                String color = null;
                int slotId = -1;

                String command = input[0];
                switch (command) {
                    case Commands.CREATE:
                        int capacity = Integer.parseInt(input[1]);
                        int entryPointCount = Integer.parseInt(input[2]);
                        swiggyParkingLot = new ParkingLot(capacity, entryPointCount);
                        break;

                    case Commands.PARK:
                        number = input[1];
                        color = input[2];
                        int entryId = Integer.parseInt(input[3]);
                        Vehicle vehicle = VehicleCreationService.create(Type.CAR, number, color);
                        try {
                            ParkingSlot slot = swiggyParkingLot.getParkingService().park(swiggyParkingLot, vehicle);
                            System.out.printf(GlobalConstants.PARK_MSG_SUCCESS , slot.getSlotId());
                        } catch (ParkingException ex) {
                            System.out.println(GlobalConstants.PARK_MSG_ERROR);
                        }
                        break;

                    case Commands.LEAVE:
                        slotId = Integer.parseInt(input[1]);
                        swiggyParkingLot.getParkingService().leave(swiggyParkingLot, slotId);
                        System.out.printf(GlobalConstants.LEAVE_MSG , slotId);
                        break;

                    case Commands.ENQUIRY_CAR_COLOR:
                        color = input[1];
                        List<String> registrationNumbers = swiggyParkingLot.getEnquiryService()
                                                                .findRegistrationNumbersByColor(swiggyParkingLot, color);
                        GlobalUtils.printStringList(registrationNumbers);
                        break;

                    case Commands.ENQUIRY_SLOT_COLOR:
                        color = input[1];
                        List<Integer> slotNumbers = swiggyParkingLot.getEnquiryService()
                                                                .findSlotNumbersByColor(swiggyParkingLot, color);
                        GlobalUtils.printIntegerList(slotNumbers);
                        break;

                    case Commands.ENQUIRY_SLOT_REGISTRATION:
                        number = input[1];
                        int slotNumber = swiggyParkingLot.getEnquiryService()
                                                    .findSlotNumberByRegistrationNumber(swiggyParkingLot, number);
                        System.out.println(-1 == slotNumber ? GlobalConstants.NOT_FOUND : slotNumber);
                        break;

                    case Commands.STATUS:
                        List<String> statusList = swiggyParkingLot.getParkingService().getStatus(swiggyParkingLot);
                        GlobalUtils.printStringList(statusList);
                        break;

                    default:
                        System.out.println(GlobalConstants.IO_ERR);
                }

            } catch (IOException ioException) {
                System.out.println(GlobalConstants.ERROR);
            }
        }

    }

}
