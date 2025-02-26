package BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class KClosestPoints {
    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5}
        };
        int n = points.length;
        long closestDistance = closestPair(points, n);
        System.out.println("Closest Pair Distance: " + closestDistance);
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static long closestPair(int[][] coordinates, int n) {
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(coordinates[i][0], coordinates[i][1]);
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point.x));
        return findClosest(points, n);
    }

    private static long dist(Point p1, Point p2) {
        long dx = (long) (p1.x - p2.x);
        long dy = (long) (p1.y - p2.y);
        return dx * dx + dy * dy;
    }

    private static long findMinDist(Point[] pts, int n) {
        long minimum = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                minimum = Math.min(minimum, dist(pts[i], pts[j]));
            }
        }
        return minimum;
    }

    private static long stripClose(List<Point> strip, long d) {
        strip.sort(Comparator.comparingInt(point -> point.y));
        long minimum = d;
        for (int i = 0; i < strip.size(); ++i) {
            for (int j = i + 1; j < strip.size(); ++j) {
                long tmp = (long) strip.get(j).y - strip.get(i).y;
                tmp *= tmp;
                if (tmp >= minimum) {
                    break;
                } else {
                    minimum = Math.min(minimum, dist(strip.get(i), strip.get(j)));
                }
            }
        }
        return minimum;
    }

    private static long findClosest(Point[] xSorted, int n) {
        if (n <= 3) {
            return findMinDist(xSorted, n);
        }
        int mid = n / 2;
        Point midPoint = xSorted[mid];
        Point[] xSortedLeft = Arrays.copyOfRange(xSorted, 0, mid + 1);
        Point[] xSortedRight = Arrays.copyOfRange(xSorted, mid + 1, n);
        long leftDist = findClosest(xSortedLeft, mid + 1);
        long rightDist = findClosest(xSortedRight, n - mid - 1);
        long distance = Math.min(leftDist, rightDist);
        List<Point> strip = new ArrayList<>();
        for (Point point : xSorted) {
            long tmp = Math.abs((long) point.x - midPoint.x);
            tmp *= tmp;
            if (tmp < distance) {
                strip.add(point);
            }
        }
        return Math.min(distance, stripClose(strip, distance));
    }
}