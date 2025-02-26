package Arrays;
import java.util.Arrays;
public class MovePositiveNegativeToOneSide {
    public static void main(String[] args) {
        int[] a = { 9, -3, 5, -2, -8, -6, 1, 3 };
        movePositiveAndNegativeToOneSide(a);
        System.out.println(Arrays.toString(a));
    }
    private static void movePositiveAndNegativeToOneSide(int[] a) {
        int pIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}