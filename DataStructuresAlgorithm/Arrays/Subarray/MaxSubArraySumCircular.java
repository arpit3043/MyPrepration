package Arrays.Subarray;

public class MaxSubArraySumCircular {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,-3,-4,5};
        int n=arr.length;
        System.out.println(maxSubarrayInCircularSum(arr, n));
    }
    private static int maxSubarrayInCircularSum(int[] arr, int n) {
        int maxSum=0;
        int minSum=0;
        int maxValue=Integer.MIN_VALUE;
        int minValue=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0; i<n; i++) {
            sum+=arr[i];
            maxSum+=arr[i];
            maxValue=Math.max(maxSum, maxValue);
            if(maxSum<0) {
                maxSum=0;
            }
            minSum+=arr[i];
            minValue=Math.min(minSum, minValue);
            if(minSum>0) {
                minSum=0;
            }
        }
        if(sum==minValue) {
            return maxValue;
        }
        return Math.max(maxValue, sum-minValue);
    }
}