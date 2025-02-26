package Matrix;
import java.util.ArrayList;
import java.util.List;
public class setMatrixOne {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(0, 0, 0)));
        matrix.add(new ArrayList<>(List.of(0, 0, 1)));
        int n = matrix.size();
        int m = matrix.get(0).size();
        setMatrixOnes(matrix, n, m);
        printArrayList(matrix);
    }
    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> MAT, int n, int m) {
        ArrayList<Integer> rowMaker = new ArrayList<>(n);
        ArrayList<Integer> colMaker = new ArrayList<>(m);
        for (int i = 0; i < n; i++) {
            rowMaker.add(0);
        }
        for (int i = 0; i < m; i++) {
            colMaker.add(0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (MAT.get(i).get(j) == 1) {
                    rowMaker.set(i, 1);
                    colMaker.set(j, 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowMaker.get(i) == 1 || colMaker.get(j) == 1) {
                    MAT.get(i).set(j, 1);
                }
            }
        }
    }
    private static void printArrayList(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}