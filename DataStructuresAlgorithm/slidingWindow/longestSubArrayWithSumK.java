package slidingWindow;
public class longestSubArrayWithSumK {
    public static void main(String[] args) throws Exception {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int K = 15;
        System.out.println(longestSubArraySumEqualsK(arr,K));
    }
    private static int longestSubArraySumEqualsK(int[] arr, int K) {
        int i = 0;
        int sum = 0;
        int maxLen = 0;
        int N = arr.length;
        for (int j = 0; j < N; j++) {
            sum = sum + arr[j];
            while (sum > K) {
                sum -= arr[i];
                i++;
            }
            if (sum == K) {
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}