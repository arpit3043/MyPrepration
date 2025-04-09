package DesignPatterns.Structural.Decorator;

import DesignPatterns.Structural.Decorator.BasePizza.BasePizza;
import DesignPatterns.Structural.Decorator.BasePizza.Margherita;
import DesignPatterns.Structural.Decorator.ToppingDecorator.ExtraCheeze;
import DesignPatterns.Structural.Decorator.ToppingDecorator.Mushroom;

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new Mushroom(new ExtraCheeze(new Margherita()));
        System.out.println(basePizza.getDescription() + " : " + basePizza.getCost());
    }
}
