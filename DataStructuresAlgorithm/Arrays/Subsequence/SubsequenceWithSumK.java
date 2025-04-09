package Arrays.Subsequence;

public class SubsequenceWithSumK {
    public static void main(String[] args) throws Exception {
        int[] arr = {9, 2, 7};
        int K = 11;
        System.out.println(isSubSequenceWithSumK(arr, K));
    }

    private static boolean isSubSequenceWithSumK(int[] arr, int K) {
        int N = arr.length;
        for(int i=0; i<Math.pow(2, N); i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                if(checkBit(i, j)) {
                    sum += arr[j];
                }
            }
            if(sum == K) {
                return true;
            }
        }
        return false;
    }

    private static int[] subsequenceArrayWithSumK(int[] arr, int K) {
        int N = arr.length;
        int[] ans = new int[N];
        for(int i=0; i<Math.pow(2, N); i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                if(checkBit(i, j)) {
                    sum += arr[j];
                    // Store the elements in ans array
                    ans[j] = arr[j];
                } else {
                    ans[j] = 0;
                }
            }
            if(sum == K) {
                return ans;
            }
        }
        return ans;
    }

    private static boolean checkBit(int N, int i) {
        return ((N & (1 << i)) != 0);
    }
}
