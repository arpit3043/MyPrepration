package Arrays;
import java.util.Arrays;
public class RightRotateArray {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rightRotate(A, k);
        System.out.println(Arrays.toString(A));
    }
    private static void rightRotateByOne(int[] A) {
        int last = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            A[i + 1] = A[i];
        }
        A[0] = last;
    }
    private static void rightRotate(int[] A, int k) {
        if (k < 0 || k >= A.length) {
            return;
        }
        for (int i = 0; i < k; i++) {
            rightRotateByOne(A);
        }
    }
}