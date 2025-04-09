package Designs.ParkingLot.ParkingSpot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Designs.ParkingLot.ParkingLevel.Level;
import Designs.ParkingLot.Ticket.ParkingTicket;
import Designs.ParkingLot.VehicleType.Vehicle;

class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<Level> levels;
    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();

    private ParkingLot(List<Level> levels) {
        this.levels = levels;
    }

    // For initial setup
    public static ParkingLot getInstance(List<Level> levels) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot(levels);
                }
            }
        }
        return instance;
    }

    // For general usage (after init)
    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot not initialized. Call getInstance(List<Level>) first.");
        }
        return instance;
    }

    // ✅ Add this missing method
    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            ParkingSpot spot = level.park(vehicle);
            if (spot != null) {
                ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                activeTickets.put(vehicle.getNumber(), ticket);
                return ticket;
            }
        }
        return null;
    }

    public synchronized double unparkVehicle(String vehicleNumber) {
        ParkingTicket ticket = activeTickets.remove(vehicleNumber);
        if (ticket == null) return 0;
        levels.get(ticket.getSpot().getLevel()).unpark(ticket.getSpot());
        return ticket.calculateFees();
    }
}
