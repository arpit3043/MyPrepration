package TwoPointers;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.String;
public class ThreeSum {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,0,-1,0,-2,2};
        System.out.println(threeSum(arr));
    }
    private static List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<N-2; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                int low = i + 1;
                int high = N-1;
                int sum = 0;
                sum = sum-nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[low], nums[high]);
                        ans.add(triplet);
                        while (low<high && nums[low] == triplet.get(1)) {
                            low++;
                        }
                        while (high > low && nums[high] == triplet.get(2)) {
                            high--;
                        }
                    } else if(nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return ans;
    }
}