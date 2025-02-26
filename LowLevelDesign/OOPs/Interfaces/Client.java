package Interfaces;
import java.util.ArrayList;
import java.util.List;
public class Client {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();
        a.walk();

        Dog d = new Dog();
        d.bark(); 
        d.eat();
        d.walk();

        
        Animal b = new Dog();
        b.eat();
        b.walk();

        List<Animal>animalList = new ArrayList<>();
        animalList.add(new Cat());
        animalList.add(new Dog());
    }
}
