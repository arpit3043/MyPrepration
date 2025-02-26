package Interfaces;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Class cat is eating");
    }

    @Override
    public void walk() {
        System.out.println("Class cat is Walking");
    }

    public void meow() {
        System.out.println("Cat can Meow");
    }
}
