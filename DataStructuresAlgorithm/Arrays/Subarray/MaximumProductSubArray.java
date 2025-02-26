package Arrays.SubArray;
public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        int N=arr.length;
        System.out.println(maximumProductSubarray(arr, N));
    }
    private static long maximumProductSubarray(int[] arr, int n) {
        long ans = arr[0];
        long maxProd = ans;
        long minProd = ans;
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                long temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
}
