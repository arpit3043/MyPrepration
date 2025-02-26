import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // store 5 roll nos
        int[] numbers = new int[5];

        // store 5 names
        String[] names = new String[5];

        // data of 5 students: {roll no, name, marks}
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];

        Student[] students = new Student[5];
        // just declaring
        
        // Student arpit;
        // arpit = new Student();

        Student arpit = new Student(15, "Arpit Bhushan Sharma", 85.4f);
        Student rahul = new Student(18, "Rahul Rana", 90.3f);

        // arpit.rno = 10;
        // arpit.name = "Arpit Bhushan Sharma";
        // arpit.marks = 88.5f;
        
        // kunal.changeName("Shoe lover");
        // kunal.greeting();
        
        //
        System.out.println(arpit.rno);
        System.out.println(arpit.name);
        System.out.println(arpit.marks);

        // Student random = new Student(kunal);
        // System.out.println(random.name);

        // Student random2 = new Student();
        // System.out.println(random2.name);

        // Student one = new Student();
        // Student two = one;

        // one.name = "Something something";

        // System.out.println(two.name);

        // Student arpit;
        // System.out.println(Arrays.toString(students));

        // Can not change
        final int bonus = 2;
        // bonus = 3;

        // final students arpit = new Student();
        // can do arpit.name = "new name";

        // final A arpit = new A("Aditya");
        arpit.name = "Other Name";
        // cant happen
        // whena a non-primitive is final we can not reassign it
        // -> arpit = new A("new name");
    }
}

// create a class
// for every single student
class Student {
    int rno;
    String name;
    float marks;

    // we need a way to add the values of the above
    // properties object by object
    // we need one word to access every object

    void greeting() {
        System.out.println("Hello! My name is " + this.name);
    }

    void changeName(String name) {
        this.name = name;
    }

    Student  (Student other) {
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.marks;
    }

    Student () {
        // this is how you call a constructor from another constructor
        // internally: new Student (13, "default person", 100.0f);
        this (13, "default person", 100.0f);
    }

    Student arpit = new Student(17, "Arpit", 89.7f);
    // here, this will be replaced with arpit
    Student (int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }
}

class A {
    final int num = 10;
    String name;
    public A(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
