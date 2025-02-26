package Matrix;

import java.util.ArrayList;
public class SubSquareOfKSize {
    public static void main(String[] args) {

    }
    private static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(ArrayList<ArrayList<Integer>> arr, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (k == 1) {
            return arr;
        }
        for (int i = 0; i <= arr.size() - k; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= arr.get(0).size() - k; j++) {
                int sum = 0;
                for (int m = i; m < i + k; m++) {
                    for (int n = j; n < j + k; n++) {
                        sum += arr.get(m).get(n);
                    }
                }
                temp.add(sum);
            }
            ans.add(temp);
        }
        return ans;
    }
}
