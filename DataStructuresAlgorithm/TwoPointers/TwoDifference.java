package TwoPointers;
import java.util.Arrays;
public class TwoDifference {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 8, 30, 40, 100 };
        int size = arr.length;
        int n = -60;
        findPairDifference(arr, size, n);
    }

    private static boolean findPairDifference(int[] arr, int size, int target) {
        Arrays.sort(arr);
        int l = 0;
        int r = 1;
        target = Math.abs(target);
        while (l <= r && r < size) {
            int diff = arr[r] - arr[l];
            if (diff == target && l != r) {
                System.out.print("Pair Found: (" + arr[l] + ", " + arr[r] + ")");
                return true;
            } else if (diff > target) {
                l++;
            } else {
                r++;
            }
        }
        System.out.print("No such pair");
        return false;
    }
}