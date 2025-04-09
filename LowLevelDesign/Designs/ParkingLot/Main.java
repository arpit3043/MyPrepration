package Designs.ParkingLot;

import java.util.Arrays;
import java.util.List;

import Designs.ParkingLot.Gate.EntryGate;
import Designs.ParkingLot.Gate.ExitGate;
import Designs.ParkingLot.ParkingLevel.Level;
import Designs.ParkingLot.ParkingSpot.ParkingLot;
import Designs.ParkingLot.ParkingSpot.ParkingSpot;
import Designs.ParkingLot.Ticket.ParkingTicket;
import Designs.ParkingLot.VehicleType.TwoWheeler;
import Designs.ParkingLot.VehicleType.Vehicle;
import Designs.ParkingLot.VehicleType.VehicleType;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingSpot> level0Spots = Arrays.asList(
            new ParkingSpot(0, 2, VehicleType.TWO_WHEELER),
            new ParkingSpot(0, 1, VehicleType.TWO_WHEELER),
            new ParkingSpot(0, 3, VehicleType.FOUR_WHEELER)
        );

        Level level0 = new Level(0, level0Spots);
        ParkingLot lot = ParkingLot.getInstance(Arrays.asList(level0));

        EntryGate gate1 = new EntryGate(1);
        ExitGate gate1Exit = new ExitGate(1);

        Vehicle bike = new TwoWheeler("BIKE123");
        ParkingTicket ticket = gate1.enter(bike);

        Thread.sleep(500); // Simulate 2 minutes
        double fee = gate1Exit.exit(bike.getNumber());
    }
}
