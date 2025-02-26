package Math;
import java.util.ArrayList;
import java.util.Arrays;
public class TugOfWar {
    public static void main(String[] args) {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(1,2,3,4));
        int N=arr.size();
        System.out.println(tugOfWar(arr, N));
    }

    private static int tugOfWar(ArrayList<Integer> arr, int n) {
        int x = n/2;
        int ans = tugOfWarHelper(arr, 0, x, n - x, 0, 0);
        return ans;
    }

    private static int tugOfWarHelper(ArrayList<Integer> arr, int index, int chances1, int chances2, int ans1, int ans2) {
        if(chances1 < 0) {
            return Integer.MAX_VALUE;
        }
        if(chances2 < 0) {
            return Integer.MAX_VALUE;
        }
        if(chances1 == 0 && chances2 == 0) {
            return Math.abs(ans2 - ans1);
        }
        int res1 = tugOfWarHelper(arr, index + 1, chances1 - 1, chances2, ans1 + arr.get(index), ans2);
        int res2 = tugOfWarHelper(arr, index + 1, chances1, chances2 - 1, ans1, ans2 + arr.get(index));
        return Math.min(res1, res2);
    }
}