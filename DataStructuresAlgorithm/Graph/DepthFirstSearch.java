package Graph;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;
import java.util.List;
public class DepthFirstSearch {
    public static void main(String[] args) throws Exception {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1, 2, 3)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(4)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        System.out.println(dfsOfGraph(V, adj));
    }
    private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>ls = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        visited[0]=true;
        dfs(0, visited, adj, ls);
        return ls;
    }
    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer>ls) {
        visited[node]=true;
        ls.add(node);
        for(Integer it: adj.get(node)) {
            if(!visited[it]) {
                dfs(it, visited, adj, ls);
            }
        }
    }
}