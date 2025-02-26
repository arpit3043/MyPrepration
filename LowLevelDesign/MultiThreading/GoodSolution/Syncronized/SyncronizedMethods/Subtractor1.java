package MultiThreading.GoodSolution.Syncronized.SyncronizedMethods;

public class Subtractor1 implements Runnable {
    private Count1 count1;
    private static int MAX_VALUE=10000;
    public Subtractor1(Count1 count1) {
        this.count1 = count1;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            synchronized (count1){
                count1.incrementValue(-i); // CRITICAL SECTION
            }
        }
    }
}
