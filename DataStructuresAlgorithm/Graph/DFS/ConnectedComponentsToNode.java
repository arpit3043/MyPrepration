package Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponentsToNode {
    public static void main(String[] args) throws Exception {
        int N = 8;
        boolean[] visited = new boolean[N];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(5).add(6);
        graph.get(6).add(5);
        graph.get(6).add(7);
        graph.get(7).add(6);
        int count = 0;
        Arrays.fill(visited, false);
        for (int i = 0; i < N; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(graph, i, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(List<List<Integer>> graph, int src, boolean[] visited) {
        List<Integer> neighbours = graph.get(src);
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                dfs(graph, neighbour, visited);
            }
        }
    }
}

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and the recursion stack.
