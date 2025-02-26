package Matrix;
public class BuildingProjections {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        int result1 = projectionArea(grid1);
        System.out.println(result1);
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int result2 = projectionArea(grid2);
        System.out.println(result2);
    }

    private static int projectionArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int xy = 0;
        int yz = 0;
        int zx = 0;
        for (int i = 0; i < row; i++) {
            int maxInRow = 0;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 0) {
                    xy++;
                }
                maxInRow = Math.max(maxInRow, grid[i][j]);
            }
            zx += maxInRow;
        }
        for (int j = 0; j < col; j++) {
            int maxInCol = 0;
            for (int i = 0; i < row; i++) {
                maxInCol = Math.max(maxInCol, grid[i][j]);
            }
            yz += maxInCol;
        }
        return xy + yz + zx;
    }
}
