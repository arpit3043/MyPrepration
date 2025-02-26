package Arrays.SubArray;
import java.util.ArrayList;
import java.util.Arrays;
public class MaximumSubArrayAfterKConcations {
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>(Arrays.asList(1, 3, 1, 3, 1, 3));
        int K=12;
        int n=arr.size();
        System.out.println(maximumSubArraySumKConcatinations(arr, K, n));
    }
    private static long maximumSubArraySumKConcatinations(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (arr == null || arr.isEmpty() || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return kadanes(arr);
        }
        for(int i = -1; i < 2*n-1; i++){
            ls.add(arr.get((i+1)%n));
        }
        if (k == 2) {
            return kadanes(ls);
        }
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr.get(i);
        }
        if(sum > 0) {
            return ((kadanes(ls)) + sum * (k - 2));
        } else {
            return kadanes(ls);
        }
    }
    private static long kadanes(ArrayList<Integer> arr) {
        long maxSum =Integer.MIN_VALUE;
        long currSum =0;
        for(int ele:arr){
            if(currSum<0) {
                currSum =0;
            }
            currSum += ele;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}