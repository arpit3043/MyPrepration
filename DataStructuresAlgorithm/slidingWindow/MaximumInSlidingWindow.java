package slidingWindow;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
public class MaximumInSlidingWindow {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maximumInSlidingWindow(nums, k)));
    }
    private static int[] maximumInSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int j=0;
        int[] res=new int[n-k+1];
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0; i<k; i++) {
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for(int i=k; i<n; i++) {
            res[j]=nums[deque.peek()];
            while(!deque.isEmpty() && deque.peek()<i-k+1) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            j++;
        }
        res[j]=nums[deque.peek()];
        return res;
    }
}