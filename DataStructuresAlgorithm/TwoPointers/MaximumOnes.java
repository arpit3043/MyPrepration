package TwoPointers;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
public class MaximumOnes {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
        int B=1;
        System.out.println(maximumOnesInArray(arr, B));
    }

    private static ArrayList<Integer>maximumOnesInArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer>result = new ArrayList<>();
        int left=0;
        int zeroCount=0;
        int maxZeros=0;
        int maxStart=0;
        for (int right = 0; right < A.size(); right++) {
            if (A.get(right) == 0) {
                zeroCount++;
            }
            while (zeroCount > B) {
                if (A.get(left) == 0) {
                    zeroCount--;
                }
                left++;
            }
            if (right - left > maxZeros) {
                maxZeros = right - left;
                maxStart = left;
            }
        }
        for (int i=0; i<=maxZeros; i++) {
            result.add(maxStart + i);
        }
        return result;
    }
}