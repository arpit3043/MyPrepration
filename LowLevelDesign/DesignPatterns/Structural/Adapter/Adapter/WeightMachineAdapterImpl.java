package DesignPatterns.Structural.Adapter.Adapter;

import DesignPatterns.Structural.Adapter.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachine weightMachine;

    @Override
    public double getWeightInKg() {

        double weightInPound = weightMachine.getWeightInPound();

        //Convert it to KGs
        double weightInKg = weightInPound * .45;
        return weightInKg;
    }
}

