package Arrays;
public class MissingNumber {
    public static void main(String[] args) throws Exception {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
    private static int missingNumber(int[] nums) {
        int N = nums.length;
        int ans = 0;
        int totalSum = N * (N + 1) / 2;
        int arraySum = 0;
        for (int i = 0; i < N; i++) {
            arraySum += nums[i];
        }
        ans = Math.abs(arraySum - totalSum);
        return ans;
    }
}