package BackTracking;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
public class PathInMaze {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(1,1)));
        arr.add(new ArrayList<>(List.of(1,1)));
        System.out.println(findAllPaths(arr));
    }
    private static ArrayList<String> findAllPaths(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<String>ans = new ArrayList<>();
        findAllPathsHelper("", ans, arr, 0, 0);
        return ans;
    }

    private static void findAllPathsHelper(String p, ArrayList<String>ans, ArrayList<ArrayList<Integer>> arr, int row, int col) {
        int rowN=arr.size();
        int colN=arr.get(0).size();
        if(arr.get(rowN - 1).get(colN - 1) == 0) {
            return;
        }
        if(row == rowN-1 && col == colN-1) {
            ans.add(p);
            return;
        }
        if(arr.get(row).get(col) == 0) {
            return;
        }
        arr.get(row).set(col, 0);
        if(row < rowN - 1) {
            findAllPathsHelper(p+"D", ans, arr, row + 1, col);
        }
        if(col < colN - 1) {
            findAllPathsHelper(p+"R", ans, arr, row, col+1);
        }
        if(row > 0) {
            findAllPathsHelper(p+"U", ans, arr, row - 1, col);
        }
        if(col > 0) {
            findAllPathsHelper(p+"L", ans, arr, row, col - 1);
        }
        arr.get(row).set(col, 1);
    }
}
