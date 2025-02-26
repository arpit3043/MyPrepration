package Inheritance;
public class Client {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Arpit";
        s.age = 25;
        s.login();
        System.out.println(s.age + " " + s.name);
        s.psp="100";
        User u = new User();
    }
}