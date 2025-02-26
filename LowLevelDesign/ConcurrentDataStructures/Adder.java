package ConcurrentDataStructures;
public class Adder implements Runnable {
    private Count count;
    private static int MAX_VALUE=10000;
    public Adder(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            System.out.println("Adder Thread took the lock.." + System.currentTimeMillis());
            count.value.addAndGet(i); // CRITICAL SECTION
        }
        System.out.println("Adder Thread released the lock.." + System.currentTimeMillis());
    }
}