package DesignPatterns.Behavioural.StratergyPattern;

public class Main {
    public static void main(String[] args) {
        // Vehicle vehicle = new SportsVehicle();
        Vehicle vehicle = new GoodsVehicle();
        vehicle.drive();
    }
}
