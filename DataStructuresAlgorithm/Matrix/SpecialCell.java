package Matrix;
public class SpecialCell {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        int n=matrix.length;
        int m=matrix[0].length;
        System.out.println(specialCellInBinaryMatrix(n,m,matrix));
    }
    private static int specialCellInBinaryMatrix(int n, int m, int[][] mat) {
        int count = 0;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}