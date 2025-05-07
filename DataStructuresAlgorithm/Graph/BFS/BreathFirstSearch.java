package Graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
public class BreathFirstSearch {
    public static void main(String[] args) throws Exception {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1, 2, 3)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(4)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        System.out.println(bfsOfGraph(V, adj));
    }

    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);
            ArrayList<Integer> neighbors = adj.get(node);
            for (int i = 0; i < neighbors.size(); i++) {
                Integer it = neighbors.get(i);
                if (!visited[it]) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }
}