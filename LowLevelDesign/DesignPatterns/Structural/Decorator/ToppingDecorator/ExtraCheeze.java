package DesignPatterns.Structural.Decorator.ToppingDecorator;

import DesignPatterns.Structural.Decorator.BasePizza.BasePizza;

public class ExtraCheeze extends ToppingDecorator {
    BasePizza basePizza;
    public ExtraCheeze(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", ExtraCheeze";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 50.0;
    }
}
