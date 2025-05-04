package Graph;

import java.util.ArrayList;
import java.util.List;

// Detect Cycle in a Directed Graph using Topological Sort
public class DetectCycleInGraph {
    public static void main(String[] args) throws Exception {
        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            edges.add(new ArrayList<>());
        }
        edges.get(0).add(1);
        edges.get(1).add(2);
        edges.get(2).add(3);
        edges.get(3).add(4);
        edges.get(4).add(0); // Adding a cycle
        System.out.println(detectCycle(V, edges));
        // For undirected graph, we can use DFS to detect cycle
        System.out.println(isCyclicDFS( 0, -1, new boolean[V], edges));
    }

    // Function to detect cycle in a directed graph using Topological Sort
    // Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    private static boolean detectCycle(int V, List<List<Integer>> edges) {
        int[] inDegree = inDegreeGenerator(V, edges);
        List<Integer> topologicalOrder = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                topologicalOrder.add(i);
            }
        }
        for (int i = 0; i < topologicalOrder.size(); i++) {
            int node = topologicalOrder.get(i);
            for (Integer neighbor : edges.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    topologicalOrder.add(neighbor);
                }
            }
        }
        return topologicalOrder.size() != V;
    }

    private static int[] inDegreeGenerator(int V, List<List<Integer>> edges) {
        int[] inDegree = new int[V];
        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.get(i).size(); j++) {
                inDegree[edges.get(i).get(j)]++;
            }
        }
        return inDegree;
    }
}
