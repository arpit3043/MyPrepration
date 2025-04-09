package Designs.ParkingLot.Gate;

import Designs.ParkingLot.ParkingSpot.ParkingSpot;
import Designs.ParkingLot.Ticket.ParkingTicket;
import Designs.ParkingLot.VehicleType.Vehicle;

public class EntryGate {
    private final int gateId;

    public EntryGate(int gateId) {
        this.gateId = gateId;
    }

    public ParkingTicket enter(Vehicle vehicle) {
        System.out.println("Vehicle " + vehicle.getNumber() + " entered through Gate " + gateId);
        ParkingLot lot = ParkingLot.getInstance();
        ParkingTicket ticket = lot.parkVehicle(vehicle);
        if (ticket != null) {
            System.out.println("Ticket issued. Vehicle parked at Level: " +
                    ticket.getSpot().getLevel() + ", Distance: " + ticket.getSpot().getDistanceFromGate());
        } else {
            System.out.println("Parking Full for Vehicle Type: " + vehicle.getType());
        }
        return ticket;
    }

    public int getGateId() {
        return gateId;
    }
}
