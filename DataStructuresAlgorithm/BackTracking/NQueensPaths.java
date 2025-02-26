package BackTracking;
import java.util.ArrayList;
public class NQueensPaths {
    public static void main(String[] args) {
        int N=4;
        System.out.println(nQueens(N));
    }
    private static ArrayList<ArrayList<Integer>> nQueens(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        nQueensHelper(new int[n][n], 0, list);
        return list;
    }

    private static void nQueensHelper(int[][] arr, int row, ArrayList<ArrayList<Integer>> list) {
        if(row == arr.length){
            list.add(getPos(arr));
        }
        for(int col=0; col<arr.length; col++) {
            if(isSafePos(row, col, arr)) {
                arr[row][col] = 1;
                nQueensHelper(arr, row+1, list);
                arr[row][col] = 0;
            }
        }
    }

    private static boolean isSafePos(int row, int col, int[][] arr) {
        for(int r=row-1; r>=0; r--){
            if(arr[r][col] == 1) {
                return false;
            }
        }
        for(int r=row-1, c=col-1; r>=0&&c>=0; r--,c--){
            if(arr[r][c] == 1) {
                return false;
            }
        }
        for(int r=row-1, c=col+1; r>=0&&c<arr.length; r--,c++){
            if(arr[r][c] == 1) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> getPos(int[][] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] row : arr){
            for(int n : row){
                list.add(n);
            }
        }
        return list;
    }
}