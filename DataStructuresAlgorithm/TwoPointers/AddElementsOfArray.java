package TwoPointers;
import java.util.ArrayList;
import java.util.List;
public class AddElementsOfArray {
    public static void main(String[] args) throws Exception {
        int[] a = {23, 5, 2, 7, 87};
        int[] b = {4, 67, 2, 8};
        List<Integer> result = new ArrayList<>();
        addElementsOfTwoArraysInOne(a, b, result);
        System.out.print(result);
    }
    private static void addElementsOfTwoArraysInOne(int[] a, int[] b, List<Integer> result) {
        int m = a.length;
        int n = b.length;
        String str = "";
        int i = 0;
        while (i < m && i < n) {
            str = str+(a[i] + b[i]);
            i++;
        }
        while (i < m) {
            str = str+(a[i]);
            i++;
        }
        while (i < n) {
            str = str+(b[i]);
            i++;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            result.add(c - '0');
        }
    }
}