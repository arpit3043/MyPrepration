import AccessModifiers.Student;

public class OutsideClient extends Student {
    public static void main(String[] args) {
        System.out.println("Test");
        Student s2 = new Student();
        s2.age=20;
        // can not access other because age is only public.
        OutsideClient oc = new OutsideClient(); // this class is the child class of student class
        oc.age=10;
        oc.psp=20.2;
    }
}