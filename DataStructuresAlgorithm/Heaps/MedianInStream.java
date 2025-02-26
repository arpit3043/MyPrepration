package Heaps;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;
import java.lang.Integer;
public class MedianInStream {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int N=arr.length;
        System.out.println(findMedianInStream(arr, N));
    }
    private static List<Integer>findMedianInStream(int[] arr, int n) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                maxHeap.add(arr[i]);
            } else if(!maxHeap.isEmpty() && minHeap.isEmpty()) {
                if(maxHeap.peek()>arr[i]) {
                    int temp = maxHeap.peek();
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                    minHeap.offer(temp);
                } else {
                    minHeap.offer(arr[i]);
                }
            } else {
                if(minHeap.size()==maxHeap.size()) {
                    if(arr[i]<=minHeap.peek()) {
                        maxHeap.offer(arr[i]);
                    } else if(arr[i]>minHeap.peek()) {
                        int temp = minHeap.peek();
                        minHeap.poll();
                        minHeap.offer(arr[i]);
                        maxHeap.offer(temp);
                    }
                } else {
                    if(arr[i]<=maxHeap.peek()) {
                        int temp=maxHeap.peek();
                        maxHeap.poll();
                        maxHeap.offer(arr[i]);
                        minHeap.offer(temp);
                    } else {
                        minHeap.offer(arr[i]);
                    }
                }
            }
            if(minHeap.size()==(maxHeap.size()-1)) {
                ans.add(maxHeap.peek());
            } else {
                ans.add((maxHeap.peek() + minHeap.peek())>>1);
            }
        }
        return ans;
    }
}