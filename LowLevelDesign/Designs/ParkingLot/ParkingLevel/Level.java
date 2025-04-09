package Designs.ParkingLot.ParkingLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

import Designs.ParkingLot.ParkingSpot.ParkingSpot;
import Designs.ParkingLot.VehicleType.Vehicle;
import Designs.ParkingLot.VehicleType.VehicleType;
public class Level {
    private final int levelNumber;
    private final Map<VehicleType, PriorityBlockingQueue<ParkingSpot>> availableSpots;

    public Level(int levelNumber, List<ParkingSpot> spots) {
        this.levelNumber = levelNumber;
        this.availableSpots = new HashMap<>();

        for (VehicleType type : VehicleType.values()) {
            availableSpots.put(type, new PriorityBlockingQueue<>());
        }

        for (ParkingSpot spot : spots) {
            availableSpots.get(spot.getType()).offer(spot);
        }
    }

    public synchronized ParkingSpot park(Vehicle vehicle) {
        PriorityBlockingQueue<ParkingSpot> spots = availableSpots.get(vehicle.getType());
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.park(vehicle);
                spots.remove(spot);
                return spot;
            }
        }
        return null;
    }

    public synchronized void unpark(ParkingSpot spot) {
        spot.unpark();
        availableSpots.get(spot.getType()).offer(spot);
    }
}