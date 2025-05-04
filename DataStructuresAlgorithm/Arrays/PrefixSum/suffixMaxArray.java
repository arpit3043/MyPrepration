package Arrays.PrefixSum;
public class suffixMaxArray {
    public static void main(String[] args) {
        int[] arr = {2,1,3,2,1,2,4,3,1,3,1};
        int N = arr.length;
        int[] ans = suffixMax(arr, N);
        printArray(ans);
    }

    private static int[] suffixMax(int[] arr, int N) {
        int[] ans = new int[N];
        ans[N-1] = arr[N-1];
        for(int i=N-2; i>=0; i--) {
            ans[i] = Math.max(arr[i], ans[i+1]);
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