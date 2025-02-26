package Polymorphism;

public class PolyClient {
    public static void main(String[] args) {
        A a = new C(); // C in thr child class
        // Data type of a is A
        a.age=26;
        a.name="Arpit";
    }

    public void login(A a) {
        // this function can be used for both A and C
        // but it can not use the functionalities of C anywhere
    }
}
