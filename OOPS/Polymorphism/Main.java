package Polymorphism;
public class Main {
    /* Types of Polymorphism:
    -> Compile time/Static Polymorphism
    -- Achieved via method overloading(same name but type/argument/return type/ordering) can be different.
    e.g., multiple Constructors
    A a = new A()
    A a = new A(3, 4);

    -> Run time polymorphism/Dynamic Polymorphism
    -- Achieved by method overriding
    When a child class have same method as the parent class just body is different
    
    parent obj = new child()
    here, which method will be called depends on child method.

    this is known as U pCasting and this process is known as overriding.
    */

    // Java determines by Dynamic method dispatching.

    /*
    If the compiler knows at the compile-time which function is called, 
    it is called early binding. 
    If a compiler does not know at compile-time which functions to call up until the run-time, 
    it is called late binding or dynamic binding.
    
    */

    // -> Method Overriding - Child Class Override Parent's Method

    public static void main(String[] args) {
        
        Shapes shapes = new Shapes();
        Shapes circle = new Circle();
        Shapes square = new Square();
        circle.area();
        shapes.area();
        square.area();
    }

    /*
    Static methods can be inherited, but can not be overidden,
    because class 1 doesnot depends on objects

    overidding ----> objects
    static --x--> objects
    so, static methods can not be overidden

    You can inherit but you can not override

    // Polymorphism does not apply on instance variables
    */
}
