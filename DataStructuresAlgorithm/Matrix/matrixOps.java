package Matrix;
public class matrixOps {
    public static void main(String[] args) throws Exception {
        int[][] mat = {
                {1, 1, 0},
                {0, 1, 1},
                {1, 0, 0},
        };
        int n= mat.length;
        printMatrix(mat);
        System.out.println();
        swapValues(mat, n);
        toggleValue(mat, n);
        printMatrix(mat);
    }

    private static void swapValues(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            while (low < high) {
                swap(mat, i, low, i, high);
                low++;
                high--;
            }
        }
    }

    private static void toggleValue(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
            }
        }
    }

    private static void swap(int[][] mat, int row1, int col1, int row2, int col2) {
        int temp = mat[row1][col1];
        mat[row1][col1] = mat[row2][col2];
        mat[row2][col2] = temp;
    }

    private static void printMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}