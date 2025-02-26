package Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.lang.String;
public class LeaderArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        System.out.println(LeaderElements(arr));
    }
    private static List<Integer>LeaderElements(int[] a) {
        int N = a.length;
        List<Integer>ans = new ArrayList<>();
        int currRightMax = Integer.MIN_VALUE;
        for(int i=N-1; i>=0; i--) {
            if(i==N-1) {
                currRightMax = Math.max(currRightMax, a[i]);
                ans.add(currRightMax);
                continue;
            }
            if(a[i]>currRightMax) {
                currRightMax = a[i];
                ans.add(currRightMax);
            }
        }
        return ans;
    }
}