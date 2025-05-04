package Arrays.Subarray;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(arr));
    }

    private static int maxSubArraySum(int[] nums) {
        int N = nums.length;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < N; i++) {
            currentSum = maximum(nums[i], currentSum + nums[i]);
            maxSum = maximum(maxSum, currentSum);
        }
        return maxSum;
    }

    private static int maximum(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}