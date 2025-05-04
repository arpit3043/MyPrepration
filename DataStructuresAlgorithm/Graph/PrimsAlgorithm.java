package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, 2}, {0, 2, 1},
            {1, 2, 1}, {2, 3, 2},
            {3, 4, 1}
        };

        ArrayList<ArrayList<ArrayList<Integer>>> graph = generateGraphForMST(V, edges);
        int result = minimumSumSpanningTree(V, graph);
        System.out.println("Minimum Sum of Spanning Tree: " + result);
    }

    private static int minimumSumSpanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        boolean[] visited = new boolean[V];
        int sum = 0;

        priorityQueue.add(new Pair(0, 0));

        while (!priorityQueue.isEmpty()) {
            Pair current = priorityQueue.poll();
            int wt = current.distance;
            int node = current.node;

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for (List<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (!visited[adjNode]) {
                    priorityQueue.add(new Pair(adjNode, edgeWeight));
                }
            }
        }

        return sum;
    }

    private static ArrayList<ArrayList<ArrayList<Integer>>> generateGraphForMST(int V, int[][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new ArrayList<>(List.of(v, w)));
            graph.get(v).add(new ArrayList<>(List.of(u, w)));
        }

        return graph;
    }
}
// This code implements Prim's algorithm to find the minimum spanning tree (MST) of a graph.
// It uses a priority queue to efficiently select the edge with the smallest weight that connects a vertex in the MST to a vertex outside the MST.
// The graph is represented as an adjacency list, and the algorithm runs in O(E log V) time complexity, where E is the number of edges and V is the number of vertices.
// The main method demonstrates the algorithm with a sample graph, and the result is printed to the console.
// The graph is undirected and weighted, and the edges are defined in the edges array.
// The generateGraphForMST method constructs the adjacency list representation of the graph from the edges array.
// The minimumSumSpanningTree method implements Prim's algorithm to calculate the total weight of the MST.
// The Pair class is used to represent a node and its distance in the priority queue.
// Time complexity: O(E log V), where E is the number of edges and V is the number of vertices in the graph.
// Space complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.