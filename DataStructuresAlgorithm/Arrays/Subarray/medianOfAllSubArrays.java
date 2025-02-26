package Arrays.SubArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
public class medianOfAllSubArrays {
    // https://www.codingninjas.com/studio/problems/find-the-median-of-all-subarrays-of-a-particular-size_1229069?topList=love-babbar-dsa-sheet-problems
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(1,4,3,5));
        int M = 3;
        int N = arr.size();
        System.out.println(findMedianOfSubArrays(arr, N, M));
    }
    private static ArrayList<Double> findMedianOfSubArrays(ArrayList<Integer> arr, int n, int m) {
        ArrayList<Double> median = new ArrayList<>();
        for (int i = 0; i<=Math.abs(n-m); i++) {
            ArrayList<Integer> ans = new ArrayList<>(arr.subList(i, i + m));
            Collections.sort(ans);
            if (m % 2 != 0) {
                median.add((double) ans.get(m / 2));
            } else {
                double res = (ans.get(m / 2 - 1) + ans.get(m / 2)) / 2.0;
                median.add(res);
            }
        }
        return median;
    }
}