package Graph;

import java.util.Arrays;

// This code explains the floyd warshall algorithm
// to find the shortest path between all pairs of vertices in a weighted graph
// Time Complexity: O(V^3) where V is the number of vertices
// Space Complexity: O(V^2) for the distance matrix
// The algorithm uses dynamic programming to find the shortest path between all pairs of vertices

/*
 * The Floyd-Warshall algorithm is a classic algorithm for finding the shortest paths in a weighted graph 
 * with positive or negative edge weights (but with no negative cycles).
 * The algorithm is not much intutive as othern algorithms like Dijkstra's or Bellman-Ford.
 * It is more of a brute force approach, where all combiations of paths are tried to find the shortest paths.
 *
 * Nothing to be panic much on intution, it is simple brute force approach.
 * Focus on the three loops.
 *  */
public class FloydWarshall {
    public static void main(String[] args) throws Exception {
        int[][] graph = {
            {0, 1, 43},
            {1, 0, 6},
            {-1, -1, 0},
        };
        floydWarshallShortestDistance(graph);
        System.out.println(Arrays.deepToString(graph));
    }

    private static void floydWarshallShortestDistance(int[][] graph) {
        // here instead of adjency list we are using adjacency matrix
        // graph[i][j] = weight of edge from i to j, if no edge exists, weight is infinity
        // to convert from DAG to UDG, we can use add same weight edge in both directions
        // graph[i][j] = weight of edge from i to j, if no edge exists, weight is infinity
        int n = graph.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == -1) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == Integer.MAX_VALUE) {
                    graph[i][j] = -1;
                }
            }
        }
    }
}
