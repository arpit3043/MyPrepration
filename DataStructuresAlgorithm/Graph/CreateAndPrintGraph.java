package Graph;

import java.util.ArrayList;

public class CreateAndPrintGraph {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Create an ArrayList of ArrayLists to represent the adjacency list
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int output[][] = new int[n][];
        // Initialize the adjacency list with empty lists for each vertex
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        // Populate the adjacency list based on the provided edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            al.get(u).add(v); // Add v as a neighbor of u
            al.get(v).add(u); // Add u as a neighbor of v (for an undirected graph)
        }
        // Create a 2D array to store the adjacency matrix
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> line = new ArrayList<>();
            line.add(i); // Include the vertex itself in the adjacency list
            line.addAll(al.get(i)); // Add its neighbors
            output[i] = new int[line.size()];
            // Convert the ArrayList to an array for the output
            for (int j = 0; j < line.size(); j++) {
                output[i][j] = line.get(j);
            }
        }
        return output; // Return the adjacency matrix
    }
}