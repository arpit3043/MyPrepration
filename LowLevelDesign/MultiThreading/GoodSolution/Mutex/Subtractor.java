package MultiThreading.GoodSolution.Mutex;
import java.util.concurrent.locks.Lock;
public class Subtractor implements Runnable {
    private Count count;
    private Lock lock;
    private static int MAX_VALUE=10000;
    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            lock.lock();
            System.out.println("Sub Thread took the lock.." + System.currentTimeMillis());
            this.count.value -= i; // CRITICAL SECTION
            lock.unlock();
        }
        System.out.println("Sub Thread release the lock.." + System.currentTimeMillis());
    }
}