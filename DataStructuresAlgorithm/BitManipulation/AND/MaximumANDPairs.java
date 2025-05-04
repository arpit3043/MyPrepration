// Given an array, find the maximum of (x & y) in the array
package AND;
import java.util.*;

public class MaximumANDPairs {
    public static void main(String[] args) {
        List<Integer>arr = Arrays.asList(26, 13, 23, 28, 27, 7, 25);
        System.out.println("Maximum of (x & y) in the array: " + maxANDPairs(arr));
    }

    private static int maxANDPairs(List<Integer>arr) {
        int N=arr.size();
        int ans=0;
        for(int i=31; i>0; i--) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(checkSetBit(arr.get(j), i)==true) {
                    count++;
                }
            }
            if(count>=2) {
                ans = ans + (1<<i);
                for(int j=0; j<N; j++) {
                    if(!checkSetBit(arr.get(j), i)) {
                        arr.set(j, 0);
                    }
                }
            }
        }
        return ans;
    }

    private static boolean checkSetBit(int a, int b) {
        return (a & (1 << b)) != 0;
    }
}
