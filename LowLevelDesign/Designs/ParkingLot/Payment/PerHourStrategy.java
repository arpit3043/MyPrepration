package Designs.ParkingLot.Payment;

public class PerHourStrategy implements PaymentStrategy {
    public double calculateFee(long durationMillis) {
        return Math.ceil(durationMillis / 3600000.0) * 20.0; // Rs.20 per hour
    }
}
