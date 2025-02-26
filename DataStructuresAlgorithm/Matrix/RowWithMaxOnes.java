package Matrix;
public class RowWithMaxOnes {
    public static void main(String[] args) {
        int N = 4;
        int M = 4;
        int[][] arr = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println(rowWithMax1s(arr, N, M));
    }
    private static int rowWithMax1s(int[][] arr, int n, int m) {
        int max = 0;
        int row = -1;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 1) {
                    count++;
                }
            }
            if(max<count) {
                max = count;
                row = i;
            }
        }
        return row;
    }
}