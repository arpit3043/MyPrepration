package DesignPatterns.Behavioural.StratergyPattern;
import DesignPatterns.Behavioural.StratergyPattern.Stratergy.NormalDriveStratergy;

public class GoodsVehicle extends Vehicle {
    // public void drive() {
    //     System.out.println("Goods Driving Capability");
    // }

    GoodsVehicle() {
        super(new NormalDriveStratergy());
    }
}