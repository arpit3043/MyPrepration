package MultiThreading.Adder;
public class Adder implements Runnable {
    int a;
    int b;
    public Adder(int a, int b) {
        this.a=a;
        this.b=b;
    }
    @Override
    public void run() {
        System.out.println(this.a + this.b);
    }
}