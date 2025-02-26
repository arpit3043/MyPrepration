package Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.String;
import java.lang.Integer;
public class MColoringProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        int m = 3;
        System.out.println(graphColoring(matrix, m));
    }

    private static String graphColoring(int[][] mat, int m) {
        List<List<Integer>> adj = getAdjList(mat);
        int[] color = new int[mat.length];
        Arrays.fill(color, -1);
        return graphColoringHelper(mat, m, color, 0, adj);
    }

    private static String graphColoringHelper(int[][] mat, int m, int[] color, int index, List<List<Integer>> adj){
        if(index == color.length){
            return "YES";
        }
        for(int i = 0; i < m; i++){
            if(canBeColored(index, i, color, adj)){
                color[index] = i;
                String ans =  graphColoringHelper(mat, m, color, index+1, adj);
                if(ans.equals("YES")){
                    return "YES";
                }
                color[index] = -1;
            }
        }
        return "NO";
    }

    private static boolean canBeColored(int vertex, int newColor, int[] color, List<List<Integer>> adj){
        if(color[vertex] != -1){
            return false;
        }
        for(int i : adj.get(vertex)) {
            if(color[i] == newColor){
                return false;
            }
        }
        return true;

    }

    private static List<List<Integer>> getAdjList(int [][]mat){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                if(mat[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}