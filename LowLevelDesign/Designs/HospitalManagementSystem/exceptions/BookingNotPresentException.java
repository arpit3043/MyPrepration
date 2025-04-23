package Designs.HospitalManagementSystem.exceptions;
public class BookingNotPresentException extends RuntimeException {
    public BookingNotPresentException() {
        super("Booking not present in the system.");
    }
    public BookingNotPresentException(String message) {
        super(message);
    }
}
