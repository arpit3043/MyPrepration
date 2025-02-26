package MergeSort.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.lang.Integer;
// Callable is Java Generics Interface, 
// it means it will return something
public class Sorter implements Callable<List<Integer>> {
    private List<Integer>arrayToSort;
    private ExecutorService executorService;
    public  Sorter(List<Integer> arr, ExecutorService executorService) {
        arrayToSort = arr;
        this.executorService = executorService;
    }

    // Merge Sort
    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Main Thread Name is: " + Thread.currentThread() .getName()
        + " Array is: " + arrayToSort.toString());
        // Base Case
        if(arrayToSort.size()<=1) {
            return arrayToSort;
        }
        int mid=arrayToSort.size()/2;
        List<Integer>leftArray = new ArrayList<>();
        List<Integer>rightArray = new ArrayList<>();
        for(int i=0; i<mid; ++i) {
            leftArray.add(arrayToSort.get(i));
        }
        for(int i=mid; i<arrayToSort.size(); ++i) {
            rightArray.add(arrayToSort.get(i));
        }
        // s3 HOW DO WE CALL the MERGE SORT?
        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);
        // List<Integer>leftSortedArray = leftSorter.call();
        // List<Integer>rightSortedArray = rightSorter.call();
        Future<List<Integer>>leftSortedArrayFuture = executorService.submit(leftSorter);
        Future<List<Integer>>rightSortedArrayFuture = executorService.submit(rightSorter);
        //List<Integer> sortedArray = merge(leftSortedArrayFuture.get(), rightSortedArrayFuture.get());
        // WE have gotten the sorted arrays. We need to merge them Now
        List<Integer> sortedArray = new ArrayList<>();
        // s4 USING TWO POINTERS
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < leftSortedArrayFuture.get().size() && pointer2 < rightSortedArrayFuture.get().size()) {
            if (leftSortedArrayFuture.get().get(pointer1) < rightSortedArrayFuture.get().get(pointer2)) {
                sortedArray.add(leftSortedArrayFuture.get().get(pointer1));
                pointer1++;
            } else {
                sortedArray.add(rightSortedArrayFuture.get().get(pointer2));
                pointer2++;
            }
        }
        // s5 WHAT ELSE? --> check for remaining half
        while (pointer1 < leftSortedArrayFuture.get().size()) {
            sortedArray.add(leftSortedArrayFuture.get().get(pointer1));
            pointer1++;
        }
        while (pointer2 < rightSortedArrayFuture.get().size()) {
            sortedArray.add(rightSortedArrayFuture.get().get(pointer2));
            pointer2++;
        }
        // s6 now return --> LEts go to CLIENT
        return sortedArray;
    }
}