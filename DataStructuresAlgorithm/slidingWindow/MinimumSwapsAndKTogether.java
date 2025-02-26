package slidingWindow;
public class MinimumSwapsAndKTogether {
    private static int minSwapAndKTogether(int[] arr, int n, int k) {
        int window = 0;
        int swap = 0;
        int minSwaps = Integer.MAX_VALUE;
        for (int i = 0; i<n; i++) {
            if (arr[i] <= k) {
                window++;
            }
        }
        for (int i = 0; i<window; i++) {
            if (arr[i]>k) {
                swap++;
            }
        }
        minSwaps = Math.min(minSwaps, swap);
        for (int i = window; i < n; i++) {
            if (arr[i - window] <= k && arr[i] > k) {
                swap++;
            }

            else if (arr[i - window] > k && arr[i] <= k) {
                swap--;
            }
            minSwaps = Math.min(minSwaps, swap);
        }
        return minSwaps;
    }
}
