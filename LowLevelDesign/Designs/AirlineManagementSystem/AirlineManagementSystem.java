package Designs.AirlineManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Designs.AirlineManagementSystem.booking.Booking;
import Designs.AirlineManagementSystem.booking.BookingManager;
import Designs.AirlineManagementSystem.flight.Flight;
import Designs.AirlineManagementSystem.flight.FlightSearch;
import Designs.AirlineManagementSystem.payment.Payment;
import Designs.AirlineManagementSystem.payment.PaymentProcessor;
import Designs.AirlineManagementSystem.seat.Seat;

public class AirlineManagementSystem {
    private final List<Flight> flights;
    private final List<Aircraft> aircrafts;
    private final FlightSearch flightSearch;
    private final BookingManager bookingManager;
    private final PaymentProcessor paymentProcessor;

    public AirlineManagementSystem() {
        flights = new ArrayList<>();
        aircrafts = new ArrayList<>();
        flightSearch = new FlightSearch(flights);
        bookingManager = BookingManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightSearch.searchFlights(source, destination, date);
    }

    public Booking bookFlight(Flight flight, Passenger passenger, Seat seat, double price) {
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingNumber) {
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }
}
