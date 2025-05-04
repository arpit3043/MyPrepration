package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) throws Exception {
        int V = 6;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            edges.add(new ArrayList<>());
        }
        edges.get(5).add(2);
        edges.get(5).add(0);
        edges.get(4).add(0);
        edges.get(4).add(1);
        edges.get(2).add(3);
        edges.get(3).add(1);
        edges.get(0).add(1);
        // Initialize the adjacency list
        topologicalSort(V, edges);
    }

    private static void topologicalSort(int V, List<List<Integer>>edges) {
        int[] inDegree = inDegreeGenerator(V, edges);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.print(node + " ");
            for (Integer neighbor : edges.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
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