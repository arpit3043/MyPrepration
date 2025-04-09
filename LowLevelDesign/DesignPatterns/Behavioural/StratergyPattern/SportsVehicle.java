package DesignPatterns.Behavioural.StratergyPattern;

import DesignPatterns.Behavioural.StratergyPattern.Stratergy.DriveStratergy;

public class SportsVehicle extends Vehicle {
    SportsVehicle(DriveStratergy driveStratergy) {
        super(driveStratergy);
    }

    // public void drive() {
    //     System.out.println("Sports Driving Capability");
    // }
}