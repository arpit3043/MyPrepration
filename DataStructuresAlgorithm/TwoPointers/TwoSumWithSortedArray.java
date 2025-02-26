package TwoPointers;
import java.util.Arrays;
public class TwoSumWithSortedArray {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
    private static int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int s=0;
        int e=n-1;
        while (s < e) {
            if (numbers[s] + numbers[e] == target) {
                return new int[]{s + 1, e + 1};
            } else if (numbers[s] + numbers[e] < target) {
                s++;
            } else {
                e--;
            }
        }
        return new int[]{-1, -1};
    }
}