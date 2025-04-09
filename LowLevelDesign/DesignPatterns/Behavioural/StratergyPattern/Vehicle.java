package DesignPatterns.Behavioural.StratergyPattern;

import DesignPatterns.Behavioural.StratergyPattern.Stratergy.DriveStratergy;

public class Vehicle {
    DriveStratergy driveStratergy;
    // Constructor Injection
    Vehicle(DriveStratergy driveStratergy) {
        this.driveStratergy = driveStratergy;
    }
    // public void drive() {
    //     System.out.println("Normal Driving Capability");
    // }

    public void drive() {
        driveStratergy.drive();
    }
}