package Arrays;
import java.util.Arrays;
public class LeftRotateArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int r = 2;
        leftRotate(arr, r);
        System.out.println(Arrays.toString(arr));
    }
    private static void leftRotateByOne(int[] arr) {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }
    private static void leftRotate(int[] arr, int r) {
        if (r < 0 || r >= arr.length) {
            return;
        }
        for (int i = 0; i < r; i++) {
            leftRotateByOne(arr);
        }
    }
}