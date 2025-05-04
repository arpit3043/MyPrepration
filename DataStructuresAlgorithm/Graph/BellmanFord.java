package Graph;

import java.util.ArrayList;
import java.util.List;

// Used to find the shortest path in a graph with negative weights
// Time Complexity: O(V * E) where V is the number of vertices and E is the number of edges.
// Space Complexity: O(V) for the distance array
// also detects negative weight cycles
public class BellmanFord {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1, 1)));
        edges.add(new ArrayList<>(List.of(0, 2, 4)));
        edges.add(new ArrayList<>(List.of(1, 2, 3)));
        edges.add(new ArrayList<>(List.of(1, 3, 2)));
        edges.add(new ArrayList<>(List.of(1, 3, 4)));
        edges.add(new ArrayList<>(List.of(2, 3, 2)));
        int src = 0;
        int[] distance = bellmanFord(V, edges, src);
        for (int i = 0; i < V; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    private static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int weight = edges.get(j).get(2);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Nth relaxation toCheck for negative weight cycles
        for (int j = 0; j < edges.size(); j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int weight = edges.get(j).get(2);
            // If we can still relax the edge, then there is a negative weight cycle
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                int[] temp = new int[1];
                temp[0] = -1; // Indicating negative weight cycle
                return temp;
            }
        }
        return distance;
    }
    /*
     * since the graph is directed, we can have negative weight cycles
     * but we can only detect them using the Bellman-Ford algorithm
     * if we can still relax the edge after V-1 iterations, then there is a negative weight cycle
     * we can also use the Floyd-Warshall algorithm to detect negative weight cycles
     * but it is not efficient for large graphs
     * 
     * Since in a graph of N nodes, in worst case, we will have N-1 edges to reach from first to last node
     * thereby we iterate over N-1 iterations.
     * 
     * only condition to check for bellman ford is,
     * if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
     * then distance[v] = distance[u] + weight;
    */
}
