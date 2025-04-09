package DesignPatterns.Creational.FactoryMethod.Shape;

import DesignPatterns.Creational.FactoryMethod.Factory.Shape;

public class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}
