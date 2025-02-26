import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private String name;
    private Semaphore semaphoreForConsumer;
    private Semaphore semaphoreForProducer;

    public Consumer(Queue<Shirt> store, String name, Semaphore semaphoreForProducer, Semaphore semaphoreForConsumer) {
        this.store = store;
        this.name = name;
        this.semaphoreForConsumer = semaphoreForConsumer;
        this.semaphoreForProducer = semaphoreForProducer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphoreForConsumer.acquire(); // Decreasing the consumer // wait for signal from producer
                store.poll(); // problem in this code.
                System.out.println(name + " consumed. Left shirts count = " + store.size());
                semaphoreForProducer.release(); // increasing the producer
            } catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Semaphore done this work for consumer");
            }
        }
    }
}