package DesignPatterns.Creational.FactoryMethod.Shape;

import DesignPatterns.Creational.FactoryMethod.Factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
