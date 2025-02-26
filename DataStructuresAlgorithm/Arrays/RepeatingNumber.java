package Arrays;
import java.util.Set;
import java.util.HashSet;
import java.lang.String;
import java.lang.Integer;
public class RepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
    private static int containsDuplicate(int[] nums) {
        int N = nums.length;
        int ans = 0;
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (uniques.contains(nums[i])) {
                ans = nums[i];
            }
            uniques.add(nums[i]);
        }
        return ans;
    }
}
