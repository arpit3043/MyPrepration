package DesignPatterns.Behavioural.StratergyPattern.Stratergy;
public class NormalDriveStratergy implements DriveStratergy {
    @Override
    public void drive() {
        System.out.println("Normal Driving Capability");
    }
}