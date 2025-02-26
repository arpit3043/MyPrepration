package staticExample;
public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    // Instance Variable
    static long population;

    static void message() {
        System.out.println("hello World");
        // since this is dependent on any object so, we can not do this thing
        // System.out.println(this.age);
    }

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        // Why we are using this ?
        // to access a static variable we use class name
        Human.population+=1;
    }
}