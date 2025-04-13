package DesignPatterns.Structural.Adapter.Adaptee;

import DesignPatterns.Structural.Adapter.Adaptee.WeightMachine;

public class WeightMachineForBabies implements WeightMachine {
    @Override
    public double getWeightInPound() {
        return 28;
    }
}
