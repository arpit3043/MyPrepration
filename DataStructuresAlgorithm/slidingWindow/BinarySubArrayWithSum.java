package slidingWindow;
public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
    private static int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumHelper(nums, goal)-numSubarraysWithSumHelper(nums,goal-1);
    }

    // Helper method to calculate the number of subarrays with a sum equal to 'goal'
    private static int numSubarraysWithSumHelper(int[] nums, int goal) {
        int n=nums.length;
        int i=0;
        int result=0;
        if(goal<0) {
            return 0;
        }
        for(int j=0; j<n; j++) {
            goal=goal-nums[j];
            while(goal<0) {
                goal=goal+nums[i];
                i++;
            }
            result=result+(j-i+1);
        }
        return result;
    }
}