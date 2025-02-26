package Arrays;
public class maximumConsecutiveOnes {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    private static int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int current_count = 0;
        int mask = 0;
        int N = nums.length;
        for (int i = 0; i<N; i++) {
            if (nums[i] == 1) {
                mask = (mask<<1) | 1;
            } else {
                mask = mask << 1;
            }
            if ((nums[i] & mask) != 0) {
                current_count++;
            } else {
                max_count = Math.max(max_count, current_count);
                current_count = 0;
                mask = 0;
            }
        }
        max_count = Math.max(max_count, current_count);
        return max_count;
    }
}