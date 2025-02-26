package Arrays;
public class MaxInGeneratedArray {
    public static void main(String[] args) {
        int N = 5;
        System.out.println(arrayMaximum(N));
    }
    private static int arrayMaximum(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 != 0) {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            } else {
                arr[i] = arr[i / 2];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
        }
        return max;
    }
}