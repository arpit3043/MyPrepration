package Heaps;
import java.util.Collections;
import java.util.PriorityQueue;
import java.lang.String;
import java.lang.Integer;
public class KSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15, 2};
        int K = 3;
        System.out.println(KthSmallestElement(arr, K));
    }
    private static int KthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new  PriorityQueue<>(Collections.reverseOrder());
        int  length = arr.length;
        for  (int  i = 0; i < length; i++){
            maxHeap.add(arr[i]);
            if  (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        if(!maxHeap.isEmpty()) {
            return  maxHeap.peek();
        }
        return 0;
    }
}