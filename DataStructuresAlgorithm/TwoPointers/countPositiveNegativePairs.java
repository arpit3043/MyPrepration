package TwoPointers;
import java.util.Arrays;
import java.lang.String;
public class countPositiveNegativePairs {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 6, 2, 5, -4, 3, 2, -4};
        System.out.println(countPositiveNegativePairs(arr));
    }

    private static long countPositiveNegativePairs(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long ans = 0;
        int low=0;
        int high=n-1;
        while(low<high) {
            int sum=arr[low]+arr[high];
            if (sum>0) {
                high--;
            } else if (sum<0) {
                low++;
            } else {
                long count1=1;
                long count2=1;
                low++;
                high--;
                while(low<=high && arr[low]==arr[low-1]){
                    count1++;
                    low++;
                }
                while(low<=high && arr[high]==arr[high+1]) {
                    count2++;
                    high--;
                }
                ans+=(count1)*(count2);
            }
        }
        return ans;
    }
}