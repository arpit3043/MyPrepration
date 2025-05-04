package Graph.DFS;

public class NoOfIslands {
    public static void main(String[] args) throws Exception {
        int[][] grid = {
                {1, 1, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1},
        };
        System.out.println(numberOfIslands(grid));
    }

    private static int numberOfIslands(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (grid.length == 0 || grid[0].length == 0) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    grid[i][j] = 0; // Mark the island as visited
                    visited[i][j] = true; // Mark the cell as visited
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int newRow = i + x[k];
            int newCol = j + y[k];
            if(newRow >= 0 
            && newRow < grid.length 
            && newCol >= 0 && newCol < grid[0].length 
            && grid[newRow][newCol] == 1 
            && !visited[newRow][newCol]) {
                grid[newRow][newCol] = 0; // Mark the island as visited
                visited[newRow][newCol] = true; // Mark the cell as visited
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
// Time Complexity: O(N * M) where N is the number of rows and M is the number of columns in the grid.
// Space Complexity: O(N * M) for the visited array and the recursion stack.