package Designs.ParkingLot.ParkingSpot;

import Designs.ParkingLot.VehicleType.Vehicle;
import Designs.ParkingLot.VehicleType.VehicleType;

class ParkingSpot implements Comparable<ParkingSpot> {
    private final int level;
    private final int distanceFromGate;
    private final VehicleType type;
    private Vehicle currentVehicle;

    public ParkingSpot(int level, int distanceFromGate, VehicleType type) {
        this.level = level;
        this.distanceFromGate = distanceFromGate;
        this.type = type;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return type == vehicle.getType();
    }

    public void park(Vehicle vehicle) {
        this.currentVehicle = vehicle;
    }

    public void unpark() {
        this.currentVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return currentVehicle;
    }

    public int getDistanceFromGate() {
        return distanceFromGate;
    }

    public int getLevel() {
        return level;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public int compareTo(ParkingSpot o) {
        return Integer.compare(this.distanceFromGate, o.distanceFromGate);
    }
}
