import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Using Priority Queue
        System.out.print("Top " + k + " frequent elements using Priority Queue: ");
        System.out.println(Arrays.toString(topKFrequentElementsPriorityQueue(nums, k)));
        
        // Using Bucket Sort
        System.out.print("Top " + k + " frequent elements using Bucket Sort: ");
        System.out.println(Arrays.toString(topKFrequentBucketSort(nums, k)));
    }

    static class Pair<K, V> {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int[] topKFrequentElementsPriorityQueue(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer>map = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>>priorityQueue = new PriorityQueue<>((a, b) -> a.key - b.key);
        int[] res = new int[k];

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer>entry: map.entrySet()) {
            priorityQueue.offer(new Pair<>(entry.getValue(), entry.getKey()));
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll().value;
        }
        return res;
    }

    // Approach: Bucket Sort
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // The idea is to use a bucket sort approach where we create an array of lists and put the values in the list based on their frequency.
    private static int[] topKFrequentBucketSort(int[] nums, int k) {
        int n = nums.length;
        int index = 0;

        Map<Integer, Integer>map = new HashMap<>();
        List<List<Integer>>freq = new ArrayList<>(n+1);
        int[] res = new int[k];

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int i = 0; i <= n; i++) {
            freq.add(new ArrayList<>());
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }
        
        for (int i = freq.size() - 1; i > 0 && index < k; i--) {
            List<Integer> bucket = freq.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                res[index] = bucket.get(j);
                index++;
                if (index == k) {
                    break;
                }
            }
        }
        return res;
    }
}
