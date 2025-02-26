package Inheritance;
// Multi-level Inheritance.

/* 
Multiple Inheritance is not allowed in Java
If two or multiple classes have same value then child class will get confuse
hence, Java does not support multiple Inheritance.

For this purpose, we use Interfaces.
*/
public class BoxPrice extends BoxWeight {
    double cost;
    BoxPrice () {
        super();
        this.cost = -1;
    }

    BoxPrice(BoxPrice other) {
        super(other);
        this.cost = other.cost;
    }

    public BoxPrice(double side, double weight, double cost) {
        super(side, weight);
        this.cost = cost;
    }
}