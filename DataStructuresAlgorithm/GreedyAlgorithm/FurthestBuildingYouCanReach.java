package GreedyAlgorithm;
import java.util.PriorityQueue;
public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }

    private static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<n-1;i++) {
            int diff = heights[i+1] - heights[i];
            if(diff > 0) {
                if(pq.size() < ladders) {
                    pq.add(diff);
                } else {
                    if(pq.isEmpty() || pq.peek() >= diff) {
                        bricks -= diff;
                    } else {
                        int poll = pq.poll();
                        pq.add(diff);
                        bricks -= poll;
                    }
                    if(bricks < 0) return i;
                }
            }
        }
        return n-1;
    }
}