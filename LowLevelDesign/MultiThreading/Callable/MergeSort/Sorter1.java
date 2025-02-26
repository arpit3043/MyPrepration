package MergeSort;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.lang.Integer;

// Callable is Java Generics Interface, 
// it means it will return something
public class Sorter1 implements Callable<List<Integer>> {
    private List<Integer>arrayToSort;
    public  Sorter1(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    // Merge Sort
    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Main Thread Name is: " + Thread.currentThread() .getName());
        // Base Case
        if(arrayToSort.size()<=1) {
            return arrayToSort;
        }
        int mid=arrayToSort.size()/2;
        int pointer1=0;
        int pointer2=0;
        List<Integer>leftArray = new ArrayList<>();
        List<Integer>rightArray = new ArrayList<>();
        List<Integer>sortedArray = new ArrayList<>();
        for(int i=0; i<mid; ++i) {
            leftArray.add(arrayToSort.get(i));
        }
        for(int i=mid; i<arrayToSort.size(); ++i) {
            rightArray.add(arrayToSort.get(i));
        }
        Sorter1 leftSorter = new Sorter1(leftArray);
        Sorter1 rightSorter = new Sorter1(rightArray);
        List<Integer>leftSortedArray = leftSorter.call();
        List<Integer>rightSortedArray = rightSorter.call();
        // we have gotten the sorted arrays. We need to merge them Now
        while(pointer1 < leftSortedArray.size() && pointer2 < rightSortedArray.size()) {
            if(leftSortedArray.get(pointer1)<rightSortedArray.get(pointer2)) {
                sortedArray.add(leftSortedArray.get(pointer1++));
            } else {
                sortedArray.add(rightSortedArray.get(pointer2++));
            }
        }
        while (pointer1<leftSortedArray.size()) {
            sortedArray.add(leftSortedArray.get(pointer1));
            pointer1++;
        }
        while (pointer2<rightSortedArray.size()) {
            sortedArray.add(rightSortedArray.get(pointer2));
            pointer2++;
        }
        return sortedArray;
    }
}
