package DesignPatterns.Structural.Adapter.Client;

import DesignPatterns.Structural.Adapter.Adapter.WeightMachineAdapter;
import DesignPatterns.Structural.Adapter.Adapter.WeightMachineAdapterImpl;
import DesignPatterns.Structural.Adapter.Adaptee.WeightMachineForBabies;

public class Main {
    public static void main(String[] args){
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
