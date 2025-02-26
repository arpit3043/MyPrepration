package Interfaces;

public class Dog implements Animal {
    int height=10;
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void walk() {
        System.out.println("Cat is Walking");
    }

    public void bark() {
        System.out.println("Dog can Bark");
    }
}