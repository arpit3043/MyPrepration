package Hashing;
import java.util.List;
import java.util.ArrayList;
public class AllDisappearedNumbers {
    public static void main(String[] args) throws Exception {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}