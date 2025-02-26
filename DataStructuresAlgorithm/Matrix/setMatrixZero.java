package Matrix;
public class setMatrixZero {
    public static void main(String[] args) throws Exception {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setMatrixRowsColsZeroes(matrix);
        printMatrix(matrix);
    }
    private static void setMatrixRowsColsZeroes(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[] rowMaker = new int[N];
        int[] colMaker = new int[M];
        fillArray(rowMaker, 1);
        fillArray(colMaker, 1);
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(matrix[i][j] == 0) {
                    rowMaker[i] = 0;
                    colMaker[j] = 0;
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(rowMaker[i]==0 || colMaker[j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
    }
    private static void fillArray(int[] array, int value) {
        int N = array.length;
        for (int i = 0; i<N; i++) {
            array[i] = value;
        }
    }
    private static void printMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}