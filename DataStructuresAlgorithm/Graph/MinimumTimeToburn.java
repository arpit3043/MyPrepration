package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class MinimumTimeToburn {
    static class Pair implements Comparable<Pair> {
        int u;
        int weight;

        Pair(int u, int weight) {
            this.u = u;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    static class Node {
        int v;
        int weight;

        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0, 1, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0),
                Arrays.asList(0, 1, 1, 1, 1),
                Arrays.asList(0, 0, 0, 0, 0)
        );
        int N = 5;
        int src = 0;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(1, 2));
        graph.get(1).add(new Node(2, 3));
        graph.get(2).add(new Node(3, 4));
        graph.get(3).add(new Node(4, 5));

        System.out.println(Arrays.toString(minimumTimeToBurn(graph, N, src)));
    }

    private static int[] minimumTimeToBurn(List<List<Node>> graph, int N, int src) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int[] time = new int[N];
        Arrays.fill(time, Integer.MAX_VALUE);
        priorityQueue.add(new Pair(src, 0));
        time[src] = 0;

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            int vertex = pair.u;
            int weightSoFar = pair.weight;

            if (weightSoFar > time[vertex]) {
                continue;
            }

            for (Node neighbor : graph.get(vertex)) {
                int nextVertex = neighbor.v;
                int newWeight = weightSoFar + neighbor.weight;
                if (newWeight < time[nextVertex]) {
                    time[nextVertex] = newWeight;
                    priorityQueue.add(new Pair(nextVertex, newWeight));
                }
            }
        }
        return time;
    }
    // Time Complexity: O(E log V) where E is the number of edges and V is the number of vertices.
    // Space Complexity: O(V) for the priority queue and distance array.
}
