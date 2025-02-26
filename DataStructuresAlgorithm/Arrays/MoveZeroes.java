package Arrays;
public class MoveZeroes {
    public static void main(String[] args) throws Exception {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        printArray(nums);
    }
    private static void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1) {
            return;
        }
        int l=0;
        int r=0;
        while(r<n) {
            if(nums[r]==0) {
                r++;
            } else {
                swap(nums, l, r);
                l++;
                r++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void printArray(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}