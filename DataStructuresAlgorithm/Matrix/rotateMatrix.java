package Matrix;
public class rotateMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println("Rotate Matrix Clockwise");
        rotate90Clockwise(mat);
        print(mat);
        System.out.println("Rotate Matrix Anti-Clockwise");
        rotate90AntiClockwise(mat);
        print(mat);
    }

    private static void print(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate90Clockwise(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;
            while (low < high) {
                int temp = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = temp;
                low++;
                high--;
            }
        }
    }
    private static void rotate90AntiClockwise(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int N = mat.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // swap rows
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < N; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[N-i-1][j];
                mat[N-i-1][j] = temp;
            }
        }
    }
}
