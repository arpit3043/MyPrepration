package DesignPatterns.Structural.Decorator.BasePizza;

public class FarmHousePizza extends BasePizza {
    @Override
    public String getDescription() {
        return "Farm House Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
