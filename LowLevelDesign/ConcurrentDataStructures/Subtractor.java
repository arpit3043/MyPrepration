package ConcurrentDataStructures;
public class Subtractor implements Runnable {
    private Count count;
    private static int MAX_VALUE=10000;
    public Subtractor(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            System.out.println("Sub Thread took the lock.." + System.currentTimeMillis());
            // this.count.value -= i;
            count.value.addAndGet(-i); // CRITICAL SECTION
        }
        System.out.println("Sub Thread release the lock.." + System.currentTimeMillis());
    }
}