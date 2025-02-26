package Matrix;
public class PerimeterOfIsland {
    public static void main(String[] args) {
        int[][] island = {
            { 0, 1, 1, 1},
            { 1, 1, 0, 0},
            { 1, 1, 1, 0},
            { 0, 1, 0, 0},
            { 0, 1, 1, 1}
        };
        System.out.println(findPerimeter(island));
    }
    private static int findPerimeter(int[][] island) {
        int M = island.length;
        int N = island[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] == 1) {
                    if ((i == 0 || island[i - 1][j] == 0)) {
                        count++;
                    }
                    if (i == M - 1 || island[i + 1][j] == 0) {
                        count++;
                    }
                    if (j == 0 || island[i][j - 1] == 0) {
                        count++;
                    }
                    if (j == N - 1 || island[i][j + 1] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}