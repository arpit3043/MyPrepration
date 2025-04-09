package Designs.ParkingLot.Ticket;

import Designs.ParkingLot.ParkingSpot.ParkingSpot;
import Designs.ParkingLot.Payment.MixedStrategy;
import Designs.ParkingLot.Payment.PaymentStrategy;
import Designs.ParkingLot.Payment.PerHourStrategy;
import Designs.ParkingLot.Payment.PerMinuteStrategy;
import Designs.ParkingLot.VehicleType.Vehicle;
import Designs.ParkingLot.VehicleType.VehicleType;

class ParkingTicket {
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long startTime;
    private final PaymentStrategy paymentStrategy;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.startTime = System.currentTimeMillis();
        this.paymentStrategy = getStrategy(vehicle.getType());
    }

    private PaymentStrategy getStrategy(VehicleType type) {
        switch (type) {
            case TWO_WHEELER:
                return new PerMinuteStrategy();
            case FOUR_WHEELER:
                return new PerHourStrategy();
            default:
                return new MixedStrategy();
        }
    }

    public double calculateFees() {
        long endTime = System.currentTimeMillis();
        return paymentStrategy.calculateFee(endTime - startTime);
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}
