package DesignPatterns.Behavioural.StratergyPattern;
import DesignPatterns.Behavioural.StratergyPattern.Stratergy.SportsDriveStratergy;
public class OffRoadVehicle extends Vehicle {
    // public void drive() {
    //     System.out.println("Sports Driving Capability");
    // }

    OffRoadVehicle() {
        super(new SportsDriveStratergy());
    }
}