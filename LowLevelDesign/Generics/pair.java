package Generics;

import java.util.Arrays;
import java.util.List;

class Foo {
    // Foo class can be defined elsewhere in your code, assuming it's not provided here
}

public class pair<V, S> {
    V x;
    S y;

    public void setX(V x) {
        this.x = x;
    }

    public void setY(S y) {
        this.y = y;
    }

    /*
    If instead of V & S, we use Object here, and we use string here in setY,
    then at runtime, only if we pass string type data in setY, we will get an error
    at that particular moment
    */
    public static <V, S> void doSomething(V x, S y) {
        System.out.println("Hey");
    }

    // Bounds
    public <T extends Number> double addition(T x, T y) {
        return x.doubleValue() + y.doubleValue();
    }

    // Wildcards
    public static void process1(List<? extends Foo> list) {
        /* ... */
    }

    /*
    The upper-bounded wildcard, <? extends Foo>, where Foo is any type, matches Foo and any subtype of Foo.
    The process method can access the list elements as type Foo:
    */
    public static void process(List<? extends Foo> list) {
        for (Foo elem : list) {
            // ...
        }
    }

    /*
    In the foreach clause, the elem variable iterates over each element in the list.
    Any method defined in the Foo class can now be used on elem.
    The sumOfList method returns the sum of the numbers in a list:
    */
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    /*
    The following code, using a list of Integer objects, prints sum = 6.0:
    */
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        // A list of Double values can use the same sumOfList method.
        // The following code prints sum = 7.0:
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
    }
}