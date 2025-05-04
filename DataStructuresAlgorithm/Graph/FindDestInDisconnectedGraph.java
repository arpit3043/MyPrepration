package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindDestInDisconnectedGraph {
    // If I have disconnected bi-directional graph, I can use BFS to find the destination node.
    // I can use BFS to find the destination node in a disconnected graph.
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2, 3},
            {0},
            {0, 4},
            {0},
            {2}
        };
        // Graph will look like this:
        // 0 -- 1 -- 4
        //  \    /
        //   2 -- 3
        int source = 0;
        int destination = 4;
        boolean result = bfs(source, destination, graph);
        System.out.println("Path exists: " + result);
        // Output: Path exists: true
    }

    private static boolean bfs(int source, int destination, int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (node == destination) {
                return true;
            }
            for (int i = 0; i < graph[node].length; i++) {
                Integer it = graph[node][i];
                if (!visited[it]) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
        return false;
    }
}
