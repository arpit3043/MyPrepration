package DesignPatterns.Structural.Decorator.BasePizza;

public class Margherita extends BasePizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}
