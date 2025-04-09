package DesignPatterns.Structural.Decorator.BasePizza;

public class VegDelight extends BasePizza {
    @Override
    public String getDescription() {
        return "Veg Delight Pizza";
    }

    @Override
    public double getCost() {
        return 250.0;
    }
}
