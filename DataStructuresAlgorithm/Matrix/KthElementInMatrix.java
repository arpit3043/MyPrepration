package Matrix;

public class KthElementInMatrix {
    public static void main(String[] args) {
        int N = 4;
        int K = 3;
        int[][] matrix = {
                {16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94},
        };
        System.out.println(kthSmallest(matrix, N, K));
    }


    private static int kthSmallest(int[][]mat,int n,int k) {
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(mat, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int upperBound(int[] row, int value) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int countLessOrEqual(int[][] mat, int value) {
        int n = mat.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int lb = upperBound(mat[i], value);
            count += lb;
        }
        return count;
    }
}
