package Arrays.Subsequence;

public class GenerateAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        // generateSubsequences(arr, 0, "");
        generateSubsequences(arr);
    }

    // Iterative implementation
    private static void generateSubsequences(int[] arr) {
        int n = arr.length;
        for (int length = 1; length <= n; length++) {
            for (int start = 0; start <= n - length; start++) {
                for (int i = start; i < start + length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    // Recursive implementation
    // private static void generateSubsequences(int[] arr, int index, String current) {
    //     if (index == arr.length) {
    //         System.out.print(current + " ");
    //         return;
    //     }
    //     generateSubsequences(arr, index + 1, current);
    //     generateSubsequences(arr, index + 1, current + arr[index] + "");
    // }
}
