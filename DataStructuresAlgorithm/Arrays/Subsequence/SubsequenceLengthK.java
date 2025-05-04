package Arrays.Subsequence;

import java.util.Arrays;
public class SubsequenceLengthK {
    public static void main(String[] args) {
        int[] nums = {-1,-2,3,4};
        int k = 3;
        System.out.println(Arrays.toString(maxSubsequenceOfLengthK(nums, k)));
    }
    private static int[] maxSubsequenceOfLengthK(int[] nums, int k) {
        int[] ans = new int[k];
        int sum = 0;
        int N = nums.length;
        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
            sum += nums[i];
        }
        for (int i = k; i<N; i++) {
            int idx = 0;
            int small = ans[0];
            for (int j=1; j<k; j++) {
                if (ans[j]<small) {
                    small = ans[j];
                    idx = j;
                }
            }
            if (small<nums[i]) {
                for (int m = idx+1; m<k; m++) {
                    ans[m - 1] = ans[m];
                }
                ans[k-1] = nums[i];
            }
        }
        return ans;
    }
}