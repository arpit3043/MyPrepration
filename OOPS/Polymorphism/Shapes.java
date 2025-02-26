package Polymorphism;
public class Shapes {

    // Final is also used to prevent overriding
    // final can provide performance enhancement
    // compilers are free to inlined the call to them because,
    // compiler will know that these meyhods can not be overridden.

    // final void area() ----> not possibe (late binding)

    // when a final method is called, java compiler can copy the byte-code from the,
    // sub-routine directly with the compile code of calling method,
    // hence, eliminating the over-head which one has to be resolved.

    // final is also used to prevent some class to get inherited.

    void area() { // early binding
        System.out.println("I am in shapes");
    }
    // We can use it to prevent Inheritance and polymorphism using final keyword.
    // final void area() {
        // System.out.println("I am in shapes");
    // }
}
