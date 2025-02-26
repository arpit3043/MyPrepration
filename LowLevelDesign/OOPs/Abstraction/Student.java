package Abstraction;
/*
 * How to create a class
 * class ClassName {
    *  attributes of class
    *  attributes of class
    *  attributes of class
    *  behaviour of class
    *  behaviour of class
    *  behaviour of class
    
    * creating class dont take any auxilliary space
    * however, creating object will take some space
 * }
*/
public class Student {
    // attributes
    String name;
    Integer age;
    String rollNo;
    Double psp;
    String gender;

    // Methods and Behaviours
    public void attendClass() {
        System.out.println("Student is attending the class. ");
    }

    public void printName() {
        System.out.println("The student's name is " + name);
    }

    public Double getPSP() {
        return psp;
    }

    public Double getScore() {
        return Math.pow(psp, 3);
    }
}