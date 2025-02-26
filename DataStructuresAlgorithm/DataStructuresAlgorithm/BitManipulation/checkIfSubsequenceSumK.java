import java.util.HashSet;
import java.util.Set;

public class checkIfSubsequenceSumK {
    public static void main(String[] args) {
        int[] arr = {9, 7, 2};
        int K = 18;
        System.out.println(isSubsequenceSumK(arr, K));
    }

    // Optimized Solution
    private static boolean isSubsequenceSumK(int[] arr, int K) {
        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0);

        for (int num : arr) {
            Set<Integer> currentSums = new HashSet<>(possibleSums);
            for (int sum : currentSums) {
                int newSum = sum + num;
                if (newSum == K) {
                    return true;
                }
                possibleSums.add(newSum);
            }
        }
        return possibleSums.contains(K);
    }

    // Brute Force
    // private static boolean isSubsequenceSumK(int[] arr, int K) {
    //     int n = arr.length;
    //     for(int i=0; i<Math.pow(2, n); i++) {
    //         int sum = 0;
    //         for(int j=0; j<n; j++) {
    //             if(checkSetBit(i, j)== true) {
    //                 sum += arr[j];
    //             }
    //         }
    //         if(sum==K) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // private static boolean checkSetBit(int a, int b) {
    //     if((a & (1<<b))==0) {
    //         return false;
    //     }
    //     return true;
    // }
}
