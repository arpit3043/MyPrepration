package Arrays.Subarray;

public class SubarrayWithBoundMax {
    public static void main(String[] args) {
        int[] arr = {2,9,2,5,6};
        int left = 2;
        int right = 8;
        System.out.println(numberOfSubarrayBoundedMaximum(arr, left, right));
    }

    private static int numberOfSubarrayBoundedMaximum(int[] nums, int left, int right) {
        int i = 0;
        int j = 0;
        int res = 0;
        int maxInd = -1;
        int N=nums.length;
        while(j < N){
            if(nums[j] >= left && nums[j] <= right){
                maxInd = j;
            }
            if(nums[j] > right){
                j++;
                i = j;
                maxInd = -1;
                continue;
            }
            if(maxInd != -1){
                res += maxInd - i + 1;
            }
            j++;
        }
        return res;
    }
}