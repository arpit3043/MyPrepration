package Inheritance;
public class BoxWeight extends Box {
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    BoxWeight(BoxWeight other) {
        super(other);
        weight = other.weight;
    }

    // Its also a polymorphism, it exactly means act of representing one thing in multiple ways
    BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        // super(); super is a keyword that refers to the parent class object
        /* used to get values from parent class.
         * Call the arent class constructor
         */
        super(l, h, w);

        System.out.println(super.w);
        this.weight = weight;
    }
}