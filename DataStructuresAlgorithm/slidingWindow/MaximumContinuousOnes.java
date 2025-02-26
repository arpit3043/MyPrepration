package slidingWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MaximumContinuousOnes {
    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 0, 1, 1, 1));
        System.out.println(maximumOnes(arr, 1));
    }
    private static List<Integer> maximumOnes(List<Integer> arr, int B) {
        int N = arr.size();
        List<Integer> ans = new ArrayList<>();
        int s = 0;
        int e = 0;
        int flips = 0;
        int ansE = 0;
        int ansB = 0;
        while (e < N) {
            if (arr.get(e) == 0) {
                flips++;
            }
            while (flips > B) {
                if (arr.get(s) == 0) {
                    flips--;
                }
                s++;
            }
            if (e - s > ansE - ansB) {
                ansB = s;
                ansE = e;
            }
            e++;
        }
        for (int i = ansB; i <= ansE; i++) {
            ans.add(arr.get(i));
        }
        return ans;
    }
}