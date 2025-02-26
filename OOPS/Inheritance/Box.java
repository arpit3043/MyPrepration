package Inheritance;
public class Box {
    double l;
    double w;
    double h;

    Box() {
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    // cube
    Box(double side) {
        this.l = side;
        this.w = side;
        this.h = side;
    }

    // cuboid
    Box(double l, double b, double h) {
        System.out.println("Box Class Constructor");
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box(Box old) {
        this.l = old.l;
        this.w = old.w;
        this.h = old.h;
    }

    public void displayInformation() {
        System.out.println("Running the Box");
    }
}
