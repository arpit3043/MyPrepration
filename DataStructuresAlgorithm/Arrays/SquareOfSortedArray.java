package Arrays;
import java.util.Arrays;
public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    private static int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int s = 0;
        int e = N-1;
        int[] ans = new int[N];
        for(int i=N-1; i>=0; i--) {
            int comp1 = nums[s]*nums[s];
            int comp2 = nums[e]*nums[e];
            if(comp1>comp2) {
                ans[i] = comp1;
                s++;
            } else {
                ans[i] = comp2;
                e--;
            }
        }
        return ans;
    }
}