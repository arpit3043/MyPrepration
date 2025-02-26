package BackTracking;
import java.util.ArrayList;
public class NQueens {
    public static void main(String[] args) {
        int N=5;
        System.out.println(solveNQueens(N));
    }
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        solveNQueensHelper(new int[n][n], 0, list);
        return list;
    }
    private static void solveNQueensHelper(int[][] arr, int row, ArrayList<ArrayList<Integer>> list) {
        if(row == arr.length) {
            list.add(getPos(arr));
        }
        for(int col=0; col<arr.length; col++) {
            if(isSafe(row, col, arr)){
                arr[row][col] = 1;
                solveNQueensHelper(arr, row+1, list);
                arr[row][col] = 0;
            }
        }
    }
    private static boolean isSafe(int row, int col, int[][] arr) {
        for(int r=row-1; r>=0; r--){
            if(arr[r][col] == 1) {
                return false;
            }
        }
        for(int r=row-1, c=col-1; r>=0&&c>=0; r--,c--) {
            if(arr[r][c] == 1) {
                return false;
            }
        }
        for(int r=row-1, c=col+1; r>=0&&c<arr.length; r--,c++) {
            if(arr[r][c] == 1) {
                return false;
            }
        }
        return true;
    }
    private static ArrayList<Integer> getPos(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] row : arr) {
            for(int n : row) {
                list.add(n);
            }
        }
        return list;
    }
}