package DesignPatterns.Creational.FactoryMethod.Shape;

import DesignPatterns.Creational.FactoryMethod.Factory.Shape;
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
