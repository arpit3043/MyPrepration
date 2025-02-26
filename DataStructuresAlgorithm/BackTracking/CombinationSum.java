package BackTracking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CombinationSum {
    public static void main(String[] args) {
        int[] A = {2,3,5};
        int sum = 8;
        System.out.println(combinationSum(A, sum));
    }

    private static List<List<Integer>> combinationSum(int[] ARR, int B) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(ARR, B, 0, 0, new ArrayList<>(), ans);
        return ans;
    }
    private static void combinationSumHelper(int[] arr, int b, int sum, int count,
                                             List<Integer> current, List<List<Integer>> ans) {
        int n = arr.length;
        if (sum == b) {
            Collections.sort(current);
            ans.add(new ArrayList<>(current));
            return;
        }
        if (sum > b || count == n) {
            return;
        }
        current.add(arr[count]);
        combinationSumHelper(arr, b, sum + arr[count], count + 1, new ArrayList<>(current), ans);
        current.remove(current.size() - 1);
        combinationSumHelper(arr, b, sum, count + 1, new ArrayList<>(current), ans);
    }
}
