package Math;
import java.util.ArrayList;
import java.util.List;
public class OptimumPoint {
    public static void main(String[] args) {
        int a = 1;
        int b = -2;
        int c = 1;
        ArrayList<ArrayList<Integer>> points = new ArrayList<>();
        points.add(new ArrayList<>(List.of(1, 2)));
        points.add(new ArrayList<>(List.of(3, 4)));
        points.add(new ArrayList<>(List.of(5, 6)));
        System.out.println(optimumDistance(a,b,c,points,points.size()));
    }

    private static double optimumDistance(int a, int b, int c, ArrayList<ArrayList<Integer>> points, int n) {
        double l = (-1 * 1e9);
        double h = (1 * 1e9);
        while (h - l > (1e-6)) {
            double mid1 = l + (h - l) / 3;
            double mid2 = h - (h - l) / 3;
            double dist1 = distance(a, b, c, points, n, mid1); // Fix method call
            double dist2 = distance(a, b, c, points, n, mid2); // Fix method call
            if (dist1 < dist2) {
                h = mid2;
            } else {
                l = mid1;
            }
        }
        return distance(a, b, c, points, n, (l + h) / 2);
    }

    private static double distance(int a, int b, int c, ArrayList<ArrayList<Integer>> points, int n, double X) {
        double Y = ((double) -1 * (c + (a * X))) / (double) b;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            double x1 = Math.pow(points.get(i).get(0) - X, 2);
            double y1 = Math.pow(points.get(i).get(1) - Y, 2);
            ans = ans + (Math.sqrt(x1 + y1));
        }
        return ans;
    }
}
