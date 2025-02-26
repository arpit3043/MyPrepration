package Arrays.PrefixSum;
public class productOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ans = productExceptSelf(arr);
        printArray(ans);
    }

    private static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int leftProd = 1;
        int[] ans = new int[N];
        ans[N-1] = 1;
        for(int i=N-2; i>=0; i--) {
            ans[i] = nums[i+1]*ans[i+1];
        }
        for(int i = 0; i<N; i++){
            ans[i] = leftProd * ans[i];
            leftProd = leftProd * nums[i];
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