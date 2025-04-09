package Designs.ParkingLot.Payment;

public class MixedStrategy implements PaymentStrategy {
    public double calculateFee(long durationMillis) {
        long minutes = durationMillis / 60000;
        return minutes <= 60 ? minutes * 0.5 : 30 + (minutes - 60) * 1.0;
    }
}