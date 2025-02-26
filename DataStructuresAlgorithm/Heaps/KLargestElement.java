package Heaps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.lang.String;
import java.lang.Integer;
public class KLargestElement {
    public static void main(String[] args) throws Exception {
        List<Integer>arr = new ArrayList<>(Arrays.asList(7, 10, 4, 3, 20, 15, 2));
        int K = 3;
        System.out.println(KthLargestElement(arr, K));
    }
    private static int KthLargestElement(List<Integer>arr, int K) {
        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>();
        int N = arr.size();
        for(int i=0; i<N; i++) {
            priorityQueue.add(arr.get(i));
            if(priorityQueue.size()>K) {
                priorityQueue.poll();
            }
        }
        if(!priorityQueue.isEmpty()) {
            return priorityQueue.peek();
        }
        return 0;
    }
}