package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 5;      
        int src = 0;    
        // Edge list format: {u, v, weight}
        int[][] edges = {
            {0, 1, 4}, 
            {0, 2, 8}, 
            {1, 4, 6},
            {2, 3, 2}, 
            {3, 4, 10}
        };

        // Get shortest path distances
        int[] result = dijkstra(V, edges, src);

        // Print shortest distances in one line
        for (int d : result)
            System.out.print(d + " ");
    }
    
    private static ArrayList<ArrayList<ArrayList<Integer>>>
    constructAdj(int[][] edges, int V) {
        // Initialize the adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>>adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Add edge from u to v
            ArrayList<Integer> e1 = new ArrayList<>();
            e1.add(v);
            e1.add(wt);
            adj.get(u).add(e1);

            // Since the graph is undirected, add edge from v to u
            ArrayList<Integer> e2 = new ArrayList<>();
            e2.add(u);
            e2.add(wt);
            adj.get(v).add(e2);
        }

        return adj;
    }



    // Returns shortest distances from src to all other vertices
    private static int[] dijkstra(int V, int[][] edges, int src) {
        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = 
                               constructAdj(edges, V);

        // PriorityQueue to store vertices to be processed
        // Each element is a pair: [distance, node]
        PriorityQueue<ArrayList<Integer>> pq = 
          new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        // Create a distance array and initialize all distances as infinite
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Insert source with distance 0
        dist[src] = 0;
        ArrayList<Integer> start = new ArrayList<>();
        
        start.add(0);
        start.add(src);
        pq.offer(start);

        // Loop until the priority queue is empty
        while (!pq.isEmpty()) {
            
            // Get the node with the minimum distance
            ArrayList<Integer> curr = pq.poll();
            int d = curr.get(0);
            int u = curr.get(1);

            // Traverse all adjacent vertices of the current node
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                // If there is a shorter path to v through u
                if (dist[v] > dist[u] + weight) {
                    // Update distance of v
                    dist[v] = dist[u] + weight;

                    // Add updated pair to the queue
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(dist[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }

        // Return the shortest distance array
        return dist;
    }
}
