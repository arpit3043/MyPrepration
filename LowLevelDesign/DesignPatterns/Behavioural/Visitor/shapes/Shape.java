package LowLevelDesign.DesignPatterns.Behavioural.Visitor.shapes;

import LowLevelDesign.DesignPatterns.Behavioural.Visitor.visitors.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
