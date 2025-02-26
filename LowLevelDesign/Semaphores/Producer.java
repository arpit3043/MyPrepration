
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class Producer implements Runnable {
    private Queue<Shirt> store;
    private int maxSizeOfStore;
    private String name;
    private Semaphore semaphoreForConsumer;
    private Semaphore semaphoreForProducer;

    public Producer(Queue<Shirt> store, int maxSizeOfStore, String name, Semaphore semaphoreForProducer, Semaphore semaphoreForConsumer) {
        this.store = store;
        this.maxSizeOfStore = maxSizeOfStore;
        this.name = name;
        this.semaphoreForConsumer = semaphoreForConsumer;
        this.semaphoreForProducer = semaphoreForProducer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphoreForProducer.acquire(); // Decrementing the producer
                store.offer(new Shirt());
                System.out.println(name + " produced. Left shirts count = " + store.size());
                semaphoreForConsumer.release(); // Incrementing consumer
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Semaphore done this work for Producer.");
            }
        }
    }
}