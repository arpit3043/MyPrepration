package MergeSort.Futures;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            call thread name is: pool-1-thread-1 Array IS: [10, 2, 8, 11, 4, 3, 9, 1]
            call thread name is: pool-1-thread-2 Array IS: [10, 2, 8, 11]
            call thread name is: pool-1-thread-3 Array IS: [4, 3, 9, 1]
            call thread name is: pool-1-thread-4 Array IS: [10, 2]
            call thread name is: pool-1-thread-5 Array IS: [4, 3]
            call thread name is: pool-1-thread-6 Array IS: [8, 11]
        */
        System.out.println("Main Thread Name is: " + Thread.currentThread() .getName());
        List<Integer>arrayToSort = List.of(
            10, 2, 8, 11, 4, 3, 9, 1
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arrayToSort, executorService);
        //List<Integer>sortedArray = sorter.call();
        Future<List<Integer>>sortedArrayFuture = executorService.submit(sorter);
        // .get() method is a blocking call unless the value is available in future
        List<Integer>sortedList = sortedArrayFuture.get();
        for(Integer in: sortedList) {
            System.out.println(in + " ");
        }
        System.out.println("\nThe array is now sorted.");
        executorService.shutdown();
    }
}