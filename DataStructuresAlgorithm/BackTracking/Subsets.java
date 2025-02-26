package BackTracking;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.lang.String;
public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(subsets(arr));
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int idx = 0;
        subsetsHelper(nums, output, idx, ans);
        return ans;
    }
    
    private static void subsetsHelper(int[] nums, List<Integer> output, int idx, List<List<Integer>> ans) {
        int n = nums.length;
        if (idx >= n) {
            ans.add(new ArrayList<>(output));
            return;
        }
        subsetsHelper(nums, output, idx + 1, ans);
        int element = nums[idx];
        output.add(element);
        subsetsHelper(nums, output, idx + 1, ans);
        output.remove(output.size() - 1);
    }
}