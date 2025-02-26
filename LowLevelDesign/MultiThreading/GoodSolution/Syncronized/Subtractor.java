package MultiThreading.GoodSolution.Syncronized;
public class Subtractor implements Runnable {
    private Count count;
    private static int MAX_VALUE=10000;
    public Subtractor(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            synchronized (count){
                count.value -= i; // CRITICAL SECTION
            }
        }
    }
}