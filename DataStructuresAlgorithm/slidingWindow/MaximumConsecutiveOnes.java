package slidingWindow;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        List<Integer>nums = new ArrayList<>(Arrays.asList(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1));
        int K=3;
        System.out.println(longestOnesArray(nums, K));
    }

    private static int longestOnesArray(List<Integer>nums, int k) {
        int n=nums.size();
        int left=-1;
        int  right=0;
        int countOfZeroInWindow=0;
        int sizeOfWindow=0;
        int ans=Integer.MIN_VALUE;
        if (n < k) {
            return 0;
        }
        while (right<n) {
            if(nums.get(right)==0){
                countOfZeroInWindow++;
                right++;
            } else {
                right++;
            }
            while(countOfZeroInWindow>k) {
                left++;
                if(nums.get(left)==0) {
                    countOfZeroInWindow--;
                }
            }
            sizeOfWindow=right-left-1;
            ans = getMax(ans, sizeOfWindow);
        }
        return ans;
    }
    // Helper method to find the maximum
    private static int getMax(int a, int b) {
        if(a>b) {
            return a;
        } else {
            return b;
        }
    }
}
