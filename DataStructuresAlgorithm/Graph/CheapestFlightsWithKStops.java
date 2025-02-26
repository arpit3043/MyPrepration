package Graph;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.String;
public class CheapestFlightsWithKStops {
    public static void main(String[] args) throws Exception {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPriceForFlightWithKStops(n, flights, src, dst, k));
    }
    private static int findCheapestPriceForFlightWithKStops(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;
        for (int[] flight : flights) {
            adj.computeIfAbsent(
                    flight[0], key -> new ArrayList<>()
            ).add(new int[]{flight[1], flight[2]});
        }
        queue.offer(new int[]{src, 0});
        K++;
        while (!queue.isEmpty() && K > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int currNode = curr[0];
                int currPrice = curr[1];
                if (adj.containsKey(currNode)) {
                    for (int[] neighbor : adj.get(currNode)) {
                        int newPrice = currPrice + neighbor[1];
                        if (newPrice < visited[neighbor[0]]) {
                            visited[neighbor[0]] = newPrice;
                            queue.offer(new int[]{neighbor[0], newPrice});
                        }
                    }
                }
            }
            K--;
        }
        if(visited[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return visited[dst];
    }
}