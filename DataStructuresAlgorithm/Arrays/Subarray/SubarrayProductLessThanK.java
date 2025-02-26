package Arrays.SubArray;
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
    private static int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k<=1) {
            return 0;
        }
        int n = arr.length;
        int ans = 0;
        int i=0;
        int j=0;
        int p=1;
        while(j<n) {
            p = p*arr[j];
            while(p>=k) {
                ans += (j-i);
                p = p/arr[i];
                i++;
            }
            j++;
        }
        while(i<n) {
            ans = ans+(j-i);
            p = p/arr[i];
            i++;
        }
        return ans;
    }
}