package Graph;

import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int _source, int _destination, int _weight) {
        this.source = _source;
        this.destination = _destination;
        this.weight = _weight;
    }
    // Comparator functio is used for
    // sorting edges based on their weight
    // in ascending order

    @Override
    public int compareTo(Edge CompareEdge) {
        return this.weight - CompareEdge.weight;
    }
};

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int vertices = 4; // Number of vertices in the graph
        int edges = 5; // Number of edges in the graph

        Edge[] edge = new Edge[edges];
        edge[0] = new Edge(0, 1, 10);
        edge[1] = new Edge(0, 2, 6);
        edge[2] = new Edge(0, 3, 5);
        edge[3] = new Edge(1, 3, 15);
        edge[4] = new Edge(2, 3, 4);

        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        kruskal.KruskalMST(edge, vertices);
    }

    private static int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public void KruskalMST(Edge[] edge, int vertices) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        Arrays.sort(edge);
        int count = 0;
        int i = 0;
        while (count < vertices - 1) {
            Edge currentEdge = edge[i++];
            int x = find(parent, currentEdge.source);
            int y = find(parent, currentEdge.destination);
            if (x != y) {
                union(parent, x, y);
                System.out.println(currentEdge.source + " - " + currentEdge.destination + " : " + currentEdge.weight);
                count++;
            }
        }
    }
}
