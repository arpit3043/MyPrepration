package slidingWindow;
import java.util.Arrays;
public class KRadiusSubArrayAverages {
    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        int[] ans = getAveragesSlidingWindow(nums, k);
        printArray(ans);
    }
    // Sliding Window
    private static int[] getAveragesSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        long windowSum = 0;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        if(n<windowSize) {
            return result;
        }
        for (int i = 0; i < n; ++i) {
            windowSum += nums[i];
            if (i - windowSize >= 0) {
                windowSum -= nums[i - windowSize];
            }
            if (i >= windowSize - 1) {
                result[i - k] = (int) (windowSum / windowSize);
            }
        }
        return result;
    }

    // prefix Sum
    private static int[] getAveragesPrefixSum(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        if (n < windowSize) {
            return ans;
        }
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = k; i<n-k; ++i) {
            ans[i] = (int) ((prefixSum[i + k + 1] - prefixSum[i - k]) / windowSize);
        }
        return ans;
    }
    private static void printArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}