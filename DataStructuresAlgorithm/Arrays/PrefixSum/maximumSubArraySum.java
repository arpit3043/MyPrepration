package Arrays.PrefixSum;
public class maximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-3, 2, 4, -1, 3, -4, 3};
        int N = arr.length;
        System.out.println(maximumSumSubarray(arr, N));
    }
    private static int maximumSumSubarray(int[] arr, int N) {
        int minPrefixSum = 0;
        int result = Integer.MIN_VALUE;
        int[] prefixSum = prefixSumArray(arr, N);
        for (int i = 0; i < N; i++) {
            result = Math.max(result, prefixSum[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }
        return result;
    }
    private static int[] prefixSumArray(int[] arr, int N) {
        int[] prefixSum = new int[N];
        prefixSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }
}