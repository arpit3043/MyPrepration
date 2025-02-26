package Heaps;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class SmallestRangeCoveringElements {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(4, 10, 15, 24, 26));
        nums.add(List.of(0, 9, 12, 20));
        nums.add(List.of(5, 18, 22, 30));
        System.out.println(Arrays.toString(smallestRangeCoveringKElementsInList(nums)));
    }
    private static int[] smallestRangeCoveringKElementsInList(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        int max = Integer.MIN_VALUE;
        int k = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            int minElem = nums.get(i).get(0);
            int[] arr = {minElem, 0, i};
            max = Math.max(max, minElem);
            pq.add(arr);
        }
        while (true) {
            int[] min = pq.poll();
            assert min != null;
            if (res[1] - res[0] > max - min[0]) {
                res[1] = max;
                res[0] = min[0];
            }
            min[1]++;
            List<Integer> cur = nums.get(min[2]);
            if (min[1] == cur.size()) {
                break;
            } else {
                min[0] = cur.get(min[1]);
                max = Math.max(max, cur.get(min[1]));
                pq.add(min);
            }
        }
        return res;
    }
}