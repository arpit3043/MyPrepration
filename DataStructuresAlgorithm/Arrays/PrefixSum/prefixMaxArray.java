package Arrays.PrefixSum;
public class prefixMaxArray {
    public static void main(String[] args) {
        int[] arr = {2,1,3,2,1,2,4,3,1,3,1};
        int N = arr.length;
        int[] ans = prefixMax(arr, N);
        printArray(ans);
    }
    private static int[] prefixMax(int[] arr, int N) {
        int[] ans = new int[N];
        ans[0] = arr[0];
        for(int i=1; i<N; i++) {
            ans[i] = Math.max(arr[i], ans[i-1]);
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