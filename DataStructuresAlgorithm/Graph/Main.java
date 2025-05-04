package Graph;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

class createGraph {
    // public static void main(String[] args) {
    //     // Taking the input
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
        
    //     // adjacency matrix for undirected graph
    //     int[][] adj = new int[n + 1][n + 1];
        
    //     // Add the edges to the matrix
    //     for (int i = 0; i < m; i++) {
    //         // Taking the input
    //         int u = sc.nextInt();
    //         int v = sc.nextInt();
            
    //         // Adding the edges
    //         adj[u][v] = 1;
    //         adj[v][u] = 1;
    //     }
    //     sc.close();
    // }
    
    public static void main(String[] args) {
        // Taking the input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
            
        // adjacency list for undirected graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n + 1);
            
        // Initialize the adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
    
        // Add the edges to the list
        for (int i = 0; i < m; i++) {
            // Taking the input
            int u = sc.nextInt();
            int v = sc.nextInt();
                
            // Adding the edges
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    
        sc.close();
    }
}