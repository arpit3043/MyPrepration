package Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;

public class PascalTriangle {
    public static void main(String[] args) throws Exception {
        int N = 5;
        List<List<Integer>> ans = pascalTriangleGenerator(N);
        printList(ans);
    }

    private static List<List<Integer>>pascalTriangleGenerator(int N) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row<=N; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    private static List<Integer>generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> al = new ArrayList<>();
        al.add(1);
        for(int i = 1; i<=rowIndex; i++) {
            List<Integer> al2 = new ArrayList<>();
            al2.add(1);
            for (int j = 0; j < al.size() - 1; j++) {
                al2.add(al.get(j) + al.get(j + 1));
            }
            al2.add(1);
            al = al2;
        }
        return al;
    }

    private static void printList(List<List<Integer>>list) {
        for (List<Integer>it : list) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}