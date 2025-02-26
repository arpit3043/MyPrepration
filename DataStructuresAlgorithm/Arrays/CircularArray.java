package Arrays;
import java.util.Arrays;
public class CircularArray {
    public static void main(String[] args) {
        int[] arr = {1,6,4,3,5};
        System.out.println(Arrays.toString(ninjaCircularArray(arr)));
    }
    private static int[] ninjaCircularArray(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<2*n; j++) {
                int idx=j%n;
                if(nums[idx]>nums[i]) {
                    ans[i]=nums[idx];
                    break;
                }
            }
        }
        return ans;
    }
}