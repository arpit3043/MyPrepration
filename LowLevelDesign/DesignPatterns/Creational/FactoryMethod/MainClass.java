package DesignPatterns.Creational.FactoryMethod;

import DesignPatterns.Creational.FactoryMethod.Factory.Shape;
import DesignPatterns.Creational.FactoryMethod.Shape.Circle;
import DesignPatterns.Creational.FactoryMethod.Shape.Square;

public class MainClass {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw(); // Output: Drawing a Circle

        Shape square = new Square();
        square.draw(); // Output: Drawing a Square
    }
}
