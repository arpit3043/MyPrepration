package DesignPatterns.Structural.Composite;

import java.awt.Color;
import DesignPatterns.Structural.Composite.Shape.CompoundShape;
import DesignPatterns.Structural.Composite.Shape.Dot;
import DesignPatterns.Structural.Composite.editor.ImageEditor;
import DesignPatterns.Structural.Composite.Shape.Circle;
import DesignPatterns.Structural.Composite.Shape.Rectangle;

public class Main {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
            editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),
                new CompoundShape(
                new Circle(110, 110, 50, Color.RED),
                new Dot(160, 160, Color.RED)
            ),
        
            new CompoundShape(
                new Rectangle(250, 250, 100, 100, Color.GREEN),
                new Dot(240, 240, Color.GREEN),
                new Dot(240, 360, Color.GREEN),
                new Dot(360, 360, Color.GREEN),
                new Dot(360, 240, Color.GREEN)
            )
        );
    }
}
