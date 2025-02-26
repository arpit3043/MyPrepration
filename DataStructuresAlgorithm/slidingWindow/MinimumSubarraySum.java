package slidingWindow;
public class MinimumSubarraySum {
    public static void main(String[] args) throws Exception {
        int target=11;
        int[] arr = {9, 1, 5, 3, 9};
        int n=arr.length;
        System.out.println(minSubArrayLen(arr, n, target));
    }
    private static int minSubArrayLen(int[] arr, int target, int n) {
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int start=0;
        for(int i=0; i<n; i++) {
            if(arr[i]==target) {
                return 1;
            }
            sum=sum+arr[i];
            while(sum>target) {
                ans=Math.min(ans, i-start+1);
                sum=sum-arr[start];
                start++;
            }
        }
        return (ans!=Integer.MAX_VALUE)?ans:0;
    }
}