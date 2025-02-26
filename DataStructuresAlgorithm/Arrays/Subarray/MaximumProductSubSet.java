package Arrays.SubArray;
public class MaximumProductSubSet {
    public static void main(String[] args) throws Exception {
        int[] nums = {-6, 4, -5, 8, -10, 0, 8};
        System.out.println("The maximum product of a subset is "
                + findMaxProduct(nums, nums.length));
    }
    private static int findMaxProduct(int[] nums, int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int product = 1;
        int abs_min_so_far = Integer.MAX_VALUE;
        int negative = 0;
        int positive = 0;
        boolean contains_zero = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negative++;
                abs_min_so_far = Integer.min(abs_min_so_far, Math.abs(nums[i]));
            } else if (nums[i] > 0) {
                positive++;
            }
            if (nums[i] == 0) {
                contains_zero = true;
            } else {
                product = product * nums[i];
            }
        }
        if ((negative & 1) != 0) {
            product = product / -abs_min_so_far;
        }
        if (negative == 1 && positive == 0 && contains_zero) {
            product = 0;
        }
        if (negative == 0 && positive == 0 && contains_zero) {
            product = 0;
        }
        return product;
    }
}
