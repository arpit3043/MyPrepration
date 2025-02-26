package MultiThreading.Synchronization;
public class Adder implements Runnable {
    private Count count;
    static int MAX_LIMIT=10000;
    public Adder(Count count) {
        this.count=count;
    }
    @Override
    public void run() {
        for(int i=1; i<=MAX_LIMIT; i++) {
            count.value+=i;
        }
    }
}