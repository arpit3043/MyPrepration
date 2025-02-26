package Arrays.Subsequences;
public class subSequenceWithGCDK {
    public static void main(String[] args) throws Exception {
        int[] arr = {4,6,3,8};
        int K = 1;
        System.out.println(isSubSequenceWithGCDK(arr, K));
    }
    private static boolean isSubSequenceWithGCDK(int[] arr, int K) {
        int N = arr.length;
        int ans = arr[0];
        for(int i=1; i<N; i++) {
            ans = GCD(ans, arr[i]);
        }
        if(ans==K) {
            return true;
        }
        return false;
    }

    private static int GCD(int A, int B) {
        if(A==0) {
            return B;
        }
        return GCD(B%A, A);
    }
}