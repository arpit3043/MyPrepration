package BackTracking;
import java.util.ArrayList;
import java.lang.String;
public class RatInMaze {
    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = arr.length;
        System.out.println(findPath(arr, n));
    }

    private static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans= new ArrayList<>();
        if(m[0][0]==0){
            return ans;
        }
        String path="";
        int[][] visited = new int[n][n];
        fillArray(visited, 0);
        int srcX=0;
        int srcY=0;
        findPathHelper(m, n, ans, srcX, srcY, visited, path);
        return ans;
    }

    private static void findPathHelper(int[][] m, int n, ArrayList<String>ans, int x, int y, int[][] visited, String path) {
        if(x==n-1 && y==n-1) {
            ans.add(path);
            return;
        }
        visited[x][y]=1;
        int newX = x+1;
        int newY = y;
        if(isSafe(m, n, newX, newY, visited)){
            path = path + 'D';
            findPathHelper(m, n, ans, newX, newY, visited, path);
            path = path.substring(0, path.length() - 1);

        }
        newX = x;
        newY = y-1;
        if(isSafe(m, n, newX, newY, visited)){
            path = path + 'L';
            findPathHelper(m, n, ans,newX, newY, visited, path);
            path = path.substring(0, path.length() - 1);

        }
        newX = x;
        newY = y+1;
        if(isSafe(m, n, newX, newY, visited)){
            path = path + 'R';
            findPathHelper(m, n, ans, newX, newY, visited, path);
            path = path.substring(0, path.length() - 1);

        }
        newX = x-1;
        newY = y;
        if(isSafe(m, n, newX, newY, visited)){
            path = path + 'U';
            findPathHelper(m, n, ans, newX, newY, visited, path);
            path = path.substring(0, path.length() - 1);
        }
        visited[x][y]=0;
    }

    private static void fillArray(int[][] arr, int value) {
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N * M; i++) {
            arr[i/M][i%M] = value;
        }
    }

    private static boolean isSafe(int[][] m, int n, int x, int y, int[][] visited) {
        if((x >= 0 && x < n) && (y >= 0 && y < n) && (visited[x][y] == 0 && m[x][y]==1)) {
            return true;
        }
        return false;
    }
}