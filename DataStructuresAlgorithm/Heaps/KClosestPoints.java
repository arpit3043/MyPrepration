package Heaps;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
class Pair {
    int distance;
    int x;
    int y;
    Pair(int distance, int x, int y) {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }
}
public class KClosestPoints {
    public static void main(String[] args) {
        int[][] points = {
                {1, 3},
                {-2, 2},
        };
        int k = 1;
        System.out.println(Arrays.deepToString(kClosestPoints(points, k)));
    }
    private static int[][] kClosestPoints(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        for(int[] temp : points) {
            maxHeap.offer(new Pair(findDistance(temp[0] , temp[1]), temp[0], temp[1]));
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(idx < k){
            assert maxHeap.peek() != null;
            ans[idx][0] = maxHeap.peek().x;
            ans[idx][1] = maxHeap.peek().y;
            maxHeap.poll();
            idx++;
        }
        return ans;
    }

    private static int findDistance(int x,int y){
        return (x * x) + (y * y);
    }
}