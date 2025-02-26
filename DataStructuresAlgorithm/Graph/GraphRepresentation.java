package Graph;
import java.util.ArrayList;
public class GraphRepresentation {
    public static void main(String[] args) {
        int N=3;
        int M=3;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        for(int i=1; i<=N; i++) {
            for(int j=1; j<adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
