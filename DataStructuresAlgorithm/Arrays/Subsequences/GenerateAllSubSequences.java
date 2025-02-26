package Arrays.Subsequences;
import java.util.ArrayList;
public class GenerateAllSubSequences {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> path = new ArrayList<>();
        printSubsequences(arr, 0, path);
    }
    private static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {
        int N = arr.length;
        if (index == N) {
            if (!path.isEmpty()) {
                System.out.println(path);
            }
        } else {
            printSubsequences(arr, index + 1, path);
            path.add(arr[index]);
            printSubsequences(arr, index + 1, path);
            path.remove(path.size() - 1);
        }
        return;
    }
}