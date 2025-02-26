package BackTracking;
public class ReachTheDestination {
    public static void main(String[] args) throws Exception {
        int sx=1;
        int sy=1;
        int dx=3;
        int dy=5;
        System.out.println(reachDestination(sx, sy, dx, dy));
    }
    private static boolean reachDestination(int sx, int sy, int dx, int dy) {
        if (sx > dx || sy > dy) {
            return false;
        }
        if (sx == dx && sy == dy) {
            return true;
        }
        if (dx > dy) {
            return reachDestination(sx, sy, dx - dy, dy);
        }
        return reachDestination(sx, sy, dx, dy - dx);
    }
}