package Arrays.Subarray;

public class LongestSubArrayOfOne {
    public static void main(String[] args) throws Exception {
        int[] arr = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(arr));
    }
    private static int longestSubarray(int[] nums) {
        int N = nums.length;
        int left = 0;
        int zeros = 0;
        int ans = 0;
        for(int right = 0; right<N; right++) {
            if(nums[right] == 0) {
                zeros++;
            }
            while(zeros>1) {
                if(nums[left]==0) {
                    zeros--;
                }
                left++;
            }
            ans = Math.max(ans, Math.abs(right-left+1-zeros));
        }
        if(ans == N) {
            return ans-1;
        }
        return ans;
    }
}