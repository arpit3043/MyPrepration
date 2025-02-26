package Arrays.Subsets;
import java.util.ArrayList;
import java.util.Collections;
public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(subsetSum(nums));
    }
    private static ArrayList<Integer> subsetSum(int[] num) {
        int N=num.length;
        ArrayList<Integer> result = new ArrayList<>();
        fetch(num, N, 0, result, 0);
        Collections.sort(result);
        return result;
    }
    private static void fetch(int[] num, int n, int index, ArrayList<Integer> result, int sum){
        if(index == n){
            result.add(sum);
            return;
        }
        fetch(num, n, index+1, result, sum+num[index]);
        fetch(num, n, index+1, result, sum);
    }
}