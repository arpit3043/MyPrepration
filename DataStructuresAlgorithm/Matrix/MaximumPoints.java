package Matrix;
public class MaximumPoints {
    public static void main(String[] args) throws Exception {
        int[][] grid = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(maximumPoints(grid));
    }
    public static int maximumPoints(int[][] grid) {
        int Pd = 0;
        int Sd = 0;
        int ans = 0;
        int n = grid.length;
        for(int i=0; i<n; i++) {
            Pd = Pd + grid[i][i];
            Sd = Sd + grid[i][n-(i+1)];
        }
        if(n%2==0) {
            ans = Sd+Pd;
        } else {
            ans = Sd+Pd-grid[n/2][n/2];
        }
        return ans;
    }
}