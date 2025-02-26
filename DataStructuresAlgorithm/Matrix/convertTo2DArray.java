package Matrix;
public class convertTo2DArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4};
        int n=2;
        int m=2;
        int[][] ans = convert1DArrayTo2DArray(arr, m, n);
        printMatrix(ans);
    }
    private static int[][] convert1DArrayTo2DArray(int[] arr, int m, int n) {
        int len = arr.length;
        int[][] ans = new int[m][n];
        if(len!=m*n) {
            return new int[0][0];
        } else {
            for(int i=0; i<len; ++i) {
                int newRow = i/n;
                int newCol = i%n;
                ans[newRow][newCol] = arr[i];
            }
        }
        return ans;
    }
    private static void printMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}