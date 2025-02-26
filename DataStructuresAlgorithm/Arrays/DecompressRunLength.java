package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
public class DecompressRunLength {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(decompressRLElist(arr)));
    }
    private static int[] decompressRLElist(int[] nums) {
        int i = 0;
        int N = nums.length;
        ArrayList<Integer>result = new ArrayList<>();
        while(2*i<N-1) {
            int a = nums[2*i];
            int b = nums[2*i+1];
            while(a>0) {
                result.add(b);
                a--;
            }
            i++;
        }
        int[] ans = new int[result.size()];
        for(int j=0; j<ans.length; j++) {
            ans[j] = result.get(j);
        }
        return ans;
    }
}