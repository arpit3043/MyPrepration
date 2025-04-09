package DesignPatterns.Structural.Decorator.ToppingDecorator;

import DesignPatterns.Structural.Decorator.BasePizza.BasePizza;

public abstract class ToppingDecorator extends BasePizza {
    public abstract String getDescription();
    public abstract double getCost();
}
