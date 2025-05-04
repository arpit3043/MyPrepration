package Graph;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) throws Exception {
        int V = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 0} // Adding a cycle
        };
        System.out.println(isCyclicDFS(0, -1, new boolean[V], edges));
    }

    // Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    private static boolean isCyclicDFS(int node, int parent, boolean[] visited, int[][] edges) {
        visited[node] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == node || edges[i][1] == node) {
                int neighbor = edges[i][0] == node ? edges[i][1] : edges[i][0];
                if (!visited[neighbor]) {
                    if (isCyclicDFS(neighbor, node, visited, edges)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
