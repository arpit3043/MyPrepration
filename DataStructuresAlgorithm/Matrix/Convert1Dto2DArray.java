package Matrix;

import java.util.ArrayList;
import java.util.List;
public class Convert1Dto2DArray {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(findMatrixFromOneD(nums));
    }
    private static List<List<Integer>> findMatrixFromOneD(int[] nums) {
        int N = nums.length;
        int[] freq = new int[N + 1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (freq[nums[i]] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freq[nums[i]]).add(nums[i]);
            freq[nums[i]]++;
        }
        return ans;
    }
}