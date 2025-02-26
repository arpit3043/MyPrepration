package Arrays;
public class FirstMissingPositiveNumber {
    public static void main(String[] args) throws Exception {
        int[] arr = {-1, -18, 3, 9, 4, 2, 0, 1};
        System.out.println(firstMissingNumber(arr));
    }

    private static int firstMissingNumber(int[] arr) {
        int N = arr.length;
        int i = 0;
        while (i < N) {
            if (arr[i] > 0 && arr[i] <= N && arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
                int idx = arr[i] - 1;
                swap(i, idx, arr);
            } else {
                i++;
            }
        }
        for (i = 0; i < N; i++) {
            if (i != arr[i] - 1) {
                return (i + 1);
            }
        }
        return (N + 1);
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}