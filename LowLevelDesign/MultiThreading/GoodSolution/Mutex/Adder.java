package MultiThreading.GoodSolution.Mutex;
import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;
    private Lock lock;
    private static int MAX_VALUE=10000;
    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            lock.lock();
            System.out.println("Adder Thread took the lock.." + System.currentTimeMillis());
            count.value += i; // CRITICAL SECTION
            lock.unlock();
        }
        System.out.println("Adder Thread released the lock.." + System.currentTimeMillis());
    }
}