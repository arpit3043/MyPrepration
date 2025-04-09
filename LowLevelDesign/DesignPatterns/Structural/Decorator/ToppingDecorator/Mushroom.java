package DesignPatterns.Structural.Decorator.ToppingDecorator;

import DesignPatterns.Structural.Decorator.BasePizza.BasePizza;

public class Mushroom extends ToppingDecorator {
    BasePizza basePizza;
    
    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 30.0;
    }
}
