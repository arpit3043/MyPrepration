package Arrays.SubArray;
import java.util.HashSet;
import java.util.Set;
import java.lang.String;
import java.lang.Integer;

public class subArrayWithSum {
    public static void main (String[] args) {
        int[] nums = { 4, -6, 3, -1, 4, 2, 7 };
        if (hasZeroSumSubarray(nums)) {
            System.out.println("Subarray exists");
        } else {
            System.out.println("Subarray does not exist");
        }
    }
    private static Boolean hasZeroSumSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
        for (int value: nums) {
            sum += value;
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}