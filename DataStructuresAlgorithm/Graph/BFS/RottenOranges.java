package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N * M)
 * Space Complexity: O(N * M)
 * where N is the number of rows and M is the number of columns in the grid.
 * 
 * Optimization: We can reduce the space complexity to O(1) by using the grid itself to store the time taken for each orange to rot.
 * However, this would modify the original grid, which may not be acceptable in all cases.
*/
public class RottenOranges {
    static class Pair {
        int i;
        int j;
        int time;

        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 1, 2, 1},
            {1, 1, 1, 1, 1},
            {0, 2, 0, 1, 0},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 2, 0}
        };
        System.out.println(minimumTimeToRotOrangesInFourDirections(grid)); // Output should be 4
        System.out.println(minimumTimeToRotOrangesInEightDirections(grid)); // Output should be 4
        System.out.println(minimumTimeToRotOrangesInFourDirectionsOptimized(grid)); // Output should be 4
        // Note: The output may vary based on the grid configuration and the method used.
    }

    private static int minimumTimeToRotOrangesInFourDirections(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<Pair> queue = new LinkedList<>();
		int ans = -1;

		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
				}
			}
		}

		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			int cRow = pair.i;
			int cCol = pair.j;
			int cTime = pair.time;
            ans = cTime;
            for(int i=0; i<4; i++) {
                int newRow = cRow + (i == 0 ? -1 : (i == 2 ? 1 : 0));
                int newCol = cCol + (i == 1 ? 1 : (i == 3 ? -1 : 0));
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    queue.add(new Pair(newRow, newCol, cTime+1));
                    grid[newRow][newCol] = 2;
                }
            }
            // Check all 4 directions (up, right, down, left)

			if(cRow-1 >= 0 && grid[cRow-1][cCol] == 1) {
				queue.add(new Pair(cRow-1, cCol, cTime+1));
				grid[cRow-1][cCol] = 2;
			}

			if(cCol+1 < cols && grid[cRow][cCol+1] == 1) {
				queue.add(new Pair(cRow, cCol+1, cTime+1));
				grid[cRow][cCol+1] = 2;
			}

			if(cRow+1 < rows && grid[cRow+1][cCol] == 1) {
				queue.add(new Pair(cRow+1, cCol, cTime+1));
				grid[cRow+1][cCol] = 2;
			}

			if(cCol-1 >= 0 && grid[cRow][cCol-1] == 1) {
                queue.add(new Pair(cRow, cCol-1, cTime+1));
                grid[cRow][cCol-1] = 2;
            }
		}
		
		for(int i=0; i<rows; i++) {
		    for(int j=0; j<cols; j++) {
		        if(grid[i][j] == 1) {
		            return -1;
		        }
		    }
		}

		return ans;
	}

    // Using BFS Multi directional approach to find the minimum time to rot all oranges in 4 directions
    private static int minimumTimeToRotOrangesInFourDirectionsOptimized(int[][] grid) {
        // Similar to the above method but optimized for 4 directions
        // Implement the logic for 4 directions here if needed
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int ans = -1;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int count = 0;
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int cRow = pair.i;
            int cCol = pair.j;
            int cTime = pair.time;
            ans = cTime;
            for (int i = 0; i < 4; i++) {
                int newRow = cRow + x[i];
                int newCol = cCol + y[i];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    queue.add(new Pair(newRow, newCol, cTime + 1));
                    grid[newRow][newCol] = 2;
                    count--;
                }

                if (cRow - 1 >= 0 && grid[cRow - 1][cCol] == 1) {
                    queue.add(new Pair(cRow - 1, cCol, cTime + 1));
                    grid[cRow - 1][cCol] = 2;
                    count--;
                }

                if (cCol + 1 < cols && grid[cRow][cCol + 1] == 1) {
                    queue.add(new Pair(cRow, cCol + 1, cTime + 1));
                    grid[cRow][cCol + 1] = 2;
                    count--;
                }

                if (cRow + 1 < rows && grid[cRow + 1][cCol] == 1) {
                    queue.add(new Pair(cRow + 1, cCol, cTime + 1));
                    grid[cRow + 1][cCol] = 2;
                    count--;
                }

                if (cCol - 1 >= 0 && grid[cRow][cCol - 1] == 1) {
                    queue.add(new Pair(cRow, cCol - 1, cTime + 1));
                    grid[cRow][cCol - 1] = 2;
                    count--;
                }

                if (count == 0) {
                    break;
                }
            }
        }
        if(count > 0) {
            return -1;
        }
        return ans;
    }

    private static int minimumTimeToRotOrangesInEightDirections(int[][] grid) {
        // Similar to the above method but includes diagonal directions
        // Implement the logic for 8 directions here if needed
        int rows = grid.length;
		int cols = grid[0].length;
		Queue<Pair> queue = new LinkedList<>();
		int ans = -1;
        int count = 0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
				} else if(grid[i][j] == 1) {
                    count++;
                }
			}
		}

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int cRow = pair.i;
            int cCol = pair.j;
            int cTime = pair.time;

            ans = Math.max(ans, cTime);

            if(cRow-1 >= 0 && grid[cRow-1][cCol] == 1) {
                queue.add(new Pair(cRow-1, cCol, cTime+1));
                grid[cRow-1][cCol] = 2;
                count--;
            }

            if(cCol+1 < cols && grid[cRow][cCol+1] == 1) {
                queue.add(new Pair(cRow, cCol+1, cTime+1));
                grid[cRow][cCol+1] = 2;
                count--;
            }

            if(cRow+1 < rows && grid[cRow+1][cCol] == 1) {
                queue.add(new Pair(cRow+1, cCol, cTime+1));
                grid[cRow+1][cCol] = 2;
                count--;
            }

            if(cCol-1 >= 0 && grid[cRow][cCol-1] == 1) {
                queue.add(new Pair(cRow, cCol-1, cTime+1));
                grid[cRow][cCol-1] = 2;
                count--;
            }

            if(cRow-1 >= 0 && cCol-1 >= 0 && grid[cRow-1][cCol-1] == 1) {
                queue.add(new Pair(cRow-1, cCol-1, cTime+1));
                grid[cRow-1][cCol-1] = 2;
                count--;
            }

            if(cRow-1 >= 0 && cCol+1 < cols && grid[cRow-1][cCol+1] == 1) {
                queue.add(new Pair(cRow-1, cCol+1, cTime+1));
                grid[cRow-1][cCol+1] = 2;
                count--;
            }

            if(cRow+1 < rows && cCol-1 >= 0 && grid[cRow+1][cCol-1] == 1) {
                queue.add(new Pair(cRow+1, cCol-1, cTime+1));
                grid[cRow+1][cCol-1] = 2;
                count--;
            }

            if(cRow+1 < rows && cCol+1 < cols && grid[cRow+1][cCol+1] == 1) {
                queue.add(new Pair(cRow+1, cCol+1, cTime+1));
                grid[cRow+1][cCol+1] = 2;
                count--;
            }
        }
        if(count > 0) {
            return -1;
        }
        return ans;
    }
}