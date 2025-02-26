package BasicAlgorithms.Arrays;
public class kadaneAlgorithm {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is: "
                + maxSubArraySum(a));
    }
    private static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int maximumSoFar = Integer.MIN_VALUE;
        int currentMaximumSum = 0;
        for (int i = 0; i < size; i++) {
            if(currentMaximumSum>=0) {
                currentMaximumSum+=arr[i];
            }
            if(currentMaximumSum<0) {
                currentMaximumSum = arr[i];
            }
            maximumSoFar = Math.max(maximumSoFar, currentMaximumSum);
        }
        return maximumSoFar;
    }
}
