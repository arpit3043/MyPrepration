package BitManipulation;
import java.io.IOException;
public class subsequenceWithSumK {
    public static void main(String[] args) throws Exception, IOException {
        int[] arr = {9, 2, 7};
        int K = 11;
        System.out.println(isSubSequenceSum(arr, K));
    }
    private static boolean isSubSequenceSum(int[] arr, int K) {
        int N = arr.length;
        for(int i=0; i<Math.pow(2, N); i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                if(checkSetBit(i, j)) {
                    sum=sum+arr[j];
                }
            }
            if(sum==K) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSetBit(int N, int i) {
        if ((N & (1 << i)) != (1 << i)) {
            return false;
        }
        return true;
    }
}