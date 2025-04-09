package Designs.ParkingLot.Payment;

public class PerMinuteStrategy implements PaymentStrategy {
    public double calculateFee(long durationMillis) {
        return Math.ceil(durationMillis / 60000.0) * 1.0; // Rs.1 per minute
    }
}
