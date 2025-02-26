package TwoPointers;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        printArray(ans);
    }
    private static int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int[] ans = new int[N];
        int i = 0;
        int j = N-1;
        while(i<j) {
            int sum = nums[i] + nums[j];
            if(sum==target) {

            }
            if(sum<target) {
                i++;
            }
            if(sum>target) {
                j--;
            }
        }
        return ans;
    }
    private static void printArray(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}