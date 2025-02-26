package AND;

import java.util.Arrays;
import java.util.List;

public class MinANDPairs {
    public static void main(String[] args) {
        List<Integer>arr = Arrays.asList(26, 13, 23, 28, 27, 7, 25);
        System.out.println("Minimum of (x & y) in the array: " + minimumANDPairs(arr));
    }

    private static int minimumANDPairs(List<Integer>arr) {
        int N=arr.size();
        int min=Integer.MAX_VALUE;
        for(int bit=31; bit>=0; bit--) {
            int count = 0;
            for(int i=0; i<N; i++) {
                if(checkSetBit(arr.get(i), bit)==true) {
                    count++;
                }
            }
            if(count>1) {
                min = Math.min(min, (1<<bit) * count);
            }
        }
        return min;
    }

    private static boolean checkSetBit(int a, int b) {
        return (a & (1 << b)) != 0;
    }
}
