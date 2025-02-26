package MultiThreading.GoodSolution.Syncronized.SyncronizedMethods;

public class Client1 {
    public static void main(String[] args) throws InterruptedException {
        Count1 count1 = new Count1();
        Adder1 adder1 = new Adder1(count1);
        Subtractor1 subtractor1 = new Subtractor1(count1);
        Thread t1 = new Thread(adder1);
        Thread t2 = new Thread(subtractor1);
        t1.start();
        t2.start();

        t1.join(); // waits for thread completion.
        t2.join();
        System.out.println(count1.getValue());
    }
}
