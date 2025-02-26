package Arrays;
public class maximumProduct {
    public static void main (String[] args) {
        int[] arr = {-10, -3, 5, 6, -2};
        findMaximumProduct(arr);
    }

    private static void findMaximumProduct(int[] A) {
        int max1 = A[0];
        int max2 = Integer.MIN_VALUE;
        int min1 = A[0];
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max1) {
                max2 = max1;
                max1 = A[i];
            } else if (A[i] > max2) {
                max2 = A[i];
            }
            if (A[i] < min1) {
                min2 = min1;
                min1 = A[i];
            } else if (A[i] < min2) {
                min2 = A[i];
            }
        }
        if (max1 * max2 > min1 * min2) {
            System.out.print("Pair is (" + max1 + ", " + max2 + ")");
        } else {
            System.out.print("Pair is (" + min1 + ", " + min2 + ")");
        }
    }
}