package slidingWindow;
public class MaximumAverageSum {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k=4;
        System.out.println(findMaxAverage(nums, k));
    }
    private static double findMaxAverage(int[] nums, int k) {
        int N=nums.length;
        int sum=0;
        int startIdx=0;
        int endIdx=k;
        for(int i=0; i<k; i++) {
            sum = sum+nums[i];
        }
        int maxSum=sum;
        while(endIdx<N) {
            sum=sum-nums[startIdx];
            sum=sum+nums[endIdx];
            startIdx++;
            endIdx++;
            maxSum=Math.max(maxSum, sum);
        }
        return (double)maxSum/k;
    }
}
