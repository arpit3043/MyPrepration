package Polymorphism;

public class Numbers {
    int sum(int a, int b) {
        return a+b;
    }

    int sum(int a, int b, int c) {
        return a+b+c;
    }

    void sum(int a, int b, int c, int d) {
        System.out.println(a+b+c+d);
    }

    public static void main(String[] args) {
        Numbers obj = new Numbers();
        obj.sum(2,3);
        obj.sum(1,3,5);
        obj.sum(4, 5, 6, 7);
        // It gives error because at compile time it shows error that
        // this function is not available with 5 arguments.
        // obj.sum(1, 3, 4, 5, 6);
    }
}
