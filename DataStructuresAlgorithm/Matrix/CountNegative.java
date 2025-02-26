package Matrix;
public class CountNegative {
    public static void main(String[] args) throws Exception {
        int[][] mat = {
                {-7, -3, -1, 3, 5},
                {-3, -2, 2, 4, 6},
                {-1, 1, 3, 5, 8},
                {3, 4, 7, 8, 9}
        };
        System.out.print("The total number of negative elements present is: " + countNegativeElements(mat));
    }
    private static int countNegativeElements(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int negative = 0;
        int i = 0;
        int j = N - 1;
        if (mat != null || N != 0) {
            while (i <= M - 1 && j >= 0) {
                if (mat[i][j] < 0) {
                    negative += j + 1;
                    i++;
                } else {
                    j--;
                }
            }
            return negative;
        }
        return 0;
    }
}