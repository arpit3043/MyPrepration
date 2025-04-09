package Designs.ParkingLot.VehicleType;

// Abstract base class for all vehicles
public abstract class Vehicle {
    private final String number;
    private final VehicleType type;

    public Vehicle(String number, VehicleType type) {
        if (number == null || type == null) {
            throw new IllegalArgumentException("Vehicle number and type must not be null");
        }
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getType() {
        return type;
    }
}
