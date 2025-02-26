package slidingWindow;
import java.util.HashSet;
import java.util.Set;
public class DuplicatesInRangeK {
    public static void main(String[] args)  {
        int[] nums = { 5, 6, 8, 2, 4, 6, 9 };
        int k = 4;
        if (hasDuplicate(nums, k)) {
            System.out.println("Duplicates found");
        } else {
            System.out.println("No duplicates were found");
        }
    }
    private static boolean hasDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (i >= k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}