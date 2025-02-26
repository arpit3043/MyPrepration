package MergeSort;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.lang.String;
import java.lang.Integer;

public class Client1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main Thread Name is: " + Thread.currentThread() .getName());
        List<Integer>arrayToSort = List.of(
            10, 2, 8, 11, 4, 3, 9, 1
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter1 sorter = new Sorter1(arrayToSort);
        // List<Integer>sortedArray = sorter.call();
        Future<List<Integer>>sortedListFuture = executorService.submit(sorter);
        List<Integer>sortedList = sortedListFuture.get();
        for(Integer in: sortedList) {
            System.out.println(in + " ");
        }
        System.out.println("The array is now sorted.");
    }
}
