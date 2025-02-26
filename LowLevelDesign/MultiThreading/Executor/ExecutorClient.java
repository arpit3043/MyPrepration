import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorClient {
    public static void main(String[] args) {
        System.out.println("Name of my thread is:  "
        + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for(int i=0; i<1000; i++) {
            if(i==15) {
                System.out.println("Task is a multiple of 3 & 5 " + i);
            }
            PrintNumberTask task = new PrintNumberTask(i);
            executorService.submit(task);
        }
    }
}
