package Arrays;
public class LeaderInArray {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 5, 1, 6, 9, 7 };
        int index = findIndex(nums);
        if (index >= 0 && index < nums.length) {
            System.out.println("The required index is " + index);
        } else {
            System.out.println("Invalid Input");
        }
    }
    public static int findIndex(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return -1;
        }
        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i - 1]);
        }
        int[] right = new int[n];
        right[n-1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i + 1]);
        }
        for (int i = 1; i < n-1; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) {
                return i;
            }
        }
        return -1;
    }
}