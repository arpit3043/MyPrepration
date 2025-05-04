package Arrays.PrefixSum;
public class prefixSumArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2, 1, 2, 4, 3, 1, 3, 1};
        int N = arr.length;
        int[] ans = calculatePrefixSum(arr, N);
        printArray(ans);
    }
    private static int[] calculatePrefixSum(int[] arr, int N) {
        int[] prefixSum = new int[N];
        prefixSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }
    private static void printArray(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
