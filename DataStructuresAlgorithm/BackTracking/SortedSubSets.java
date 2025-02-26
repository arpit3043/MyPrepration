package BackTracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class SortedSubSets {
    public static void main(String[] args) {
        int[] inputArray = {1, 2, 2};
        List<List<Integer>> subsetsResult = subsets(inputArray);
        System.out.println("All possible subsets: " + subsetsResult);
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}