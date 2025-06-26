package LowLevelDesign.DesignPatterns.Behavioural.Visitor.visitors;

import LowLevelDesign.DesignPatterns.Behavioural.Visitor.shapes.Circle;
import LowLevelDesign.DesignPatterns.Behavioural.Visitor.shapes.CompoundShape;
import LowLevelDesign.DesignPatterns.Behavioural.Visitor.shapes.Dot;
import LowLevelDesign.DesignPatterns.Behavioural.Visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}

