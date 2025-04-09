package Designs.ParkingLot.Gate;

import Designs.ParkingLot.ParkingSpot.ParkingLot;

public class ExitGate {
    private final int gateId;

    public ExitGate(int gateId) {
        this.gateId = gateId;
    }

    public double exit(String vehicleNumber) {
        System.out.println("Vehicle " + vehicleNumber + " exiting through Gate " + gateId);
        ParkingLot lot = ParkingLot.getInstance();
        double fee = lot.unparkVehicle(vehicleNumber);
        System.out.println("Total parking fee: Rs." + fee);
        return fee;
    }

    public int getGateId() {
        return gateId;
    }
}
