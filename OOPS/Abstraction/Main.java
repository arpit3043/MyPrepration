package Abstraction;
/* Hiding the un-necessary details and
showing only valueable information*/
 
public class Main {
    public static void main(String[] args) throws Exception {
        Pig myPig = new Pig(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}