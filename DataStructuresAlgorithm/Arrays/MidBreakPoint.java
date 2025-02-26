package Arrays;
import java.util.stream.IntStream;
public class MidBreakPoint {
    public static void main(String[] args) {
        int[] A = {-1, 6, 3, 1, -2, 3, 3 };
        findBreakPoint(A);
    }
    public static void findBreakPoint(int[] A) {
        if (A.length == 0) {
            return;
        }
        int total = IntStream.of(A).sum();
        int left_sum = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            if (left_sum == total - (A[i] + left_sum)) {
                System.out.println("The index is " + i);
            }
            left_sum += A[i];
        }
    }
}