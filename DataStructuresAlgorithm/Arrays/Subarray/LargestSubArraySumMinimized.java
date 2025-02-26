package Arrays.SubArray;
public class LargestSubArraySumMinimized {
    public static void main(String[] args) throws Exception {
        int[] a = {10, 4, 5, 10, 9, 10};
        int K=4;
        System.out.println(largestSubarraySumMinimized(a, K));
    }
    private static int largestSubarraySumMinimized(int []a, int k) {
        int n = a.length;
        int low = maxElement(a);
        int high = summition(a);
        while(low<= high){
            int mid = (low+high)/2;
            int possibleSubArrays = subArrysPossible(a, mid);
            if(possibleSubArrays <= k){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return low;
    }
    private static int maxElement(int[] a) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            maxi = Math.max(maxi, a[i]);
        }
        return maxi;
    }

    private static int summition(int[] a){
        int sum = 0;
        int n = a.length;
        for(int i=0; i<n; i++){
            sum += a[i];
        }
        return sum;
    }
    private static int subArrysPossible(int []a, int limit){
        int possible = 1;
        int sum = a[0];
        for(int i=1; i<a.length; i++){
            if(sum + a[i] <= limit){
                sum += a[i];
            } else {
                possible++;
                sum = a[i];
            }
        }
        return possible;
    }
}