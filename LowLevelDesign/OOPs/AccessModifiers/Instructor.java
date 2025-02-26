package AccessModifiers;

public class Instructor {
    String name;
    public static void main(String[] args) {
        Student s1=new Student();
        s1.universityName="IIT-KGP";
        s1.age=25;
        s1.psp=100;
        // s1.name; --> private anc can not be accessed and visible
    }
}