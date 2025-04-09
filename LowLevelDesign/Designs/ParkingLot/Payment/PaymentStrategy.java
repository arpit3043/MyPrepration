package Designs.ParkingLot.Payment;

public interface PaymentStrategy {
    double calculateFee(long durationMillis);
}
