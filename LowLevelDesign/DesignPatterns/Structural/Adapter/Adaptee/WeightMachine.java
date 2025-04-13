package DesignPatterns.Structural.Adapter.Adaptee;

// This is the Adaptee class which is not compatible with the client
// and needs to be adapted to work with the client.
public class WeightMachine {
    //return the weight in Pound
    public double getWeightInPound();
}