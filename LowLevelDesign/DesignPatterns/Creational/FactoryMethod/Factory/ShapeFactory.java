package DesignPatterns.Creational.FactoryMethod.Factory;

import DesignPatterns.Creational.FactoryMethod.Shape.Rectangle;
import DesignPatterns.Creational.FactoryMethod.Shape.Circle;
import DesignPatterns.Creational.FactoryMethod.Shape.Square;


public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return  (Shape)new Circle();
            case "RECTANGLE":
                return (Shape) new Rectangle();
            case "SQUARE":
                return  (Shape)new Square();
            default:
                return null;
        }
    }
}
