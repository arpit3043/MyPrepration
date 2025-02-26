package GreedyAlgorithm;
import java.util.Arrays;
public class MinimumNumberArrowsBurstBaloons {
    public static void main(String[] args) throws Exception {
        int[][] points = {
            {10, 16},
            {2, 8},
            {1, 6},
            {7, 12}
        };
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int N=points.length;
        int arrows = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < N; ++i) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }
        return arrows;
    }
}