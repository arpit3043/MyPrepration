package Matrix;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.String;
public class generatePascalTriangle {
    public static void main(String[] args) {
        int numRow = 5;
        System.out.println(generatePascalTriangle(numRow));
    }
    private static List<List<Integer>>generatePascalTriangle(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();
        if (numRows <= 0) {
            return output;
        }
        prev.add(1);
        output.add(prev);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            output.add(curr);
            prev = curr;
        }
        return output;
    }
}