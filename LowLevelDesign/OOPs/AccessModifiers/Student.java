package AccessModifiers;

public class Student {
    private String name; // Private access modifier, accessible only within this class.
    public int age;
    protected double psp;
    String universityName;

    public void changeBatch() {
        name = "Arpit";
        age=25;
        psp=100;
        universityName="IIT-KGP";
        System.out.println("Changing the batch...");
    }
}
