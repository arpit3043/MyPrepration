package BitManipulation;
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }
    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        int mask = 0;
        for(int i=0; i<n; i++) {
            ans = ans^nums[i];
            mask = mask^i;
        }
        ans = ans^mask;
        return ans;
    }
}