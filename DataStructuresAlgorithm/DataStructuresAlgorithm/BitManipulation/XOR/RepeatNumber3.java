package XOR;
// every element in the array repeats three times except the one element which repeats twice in the array
import java.util.*;

public class RepeatNumber3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,1,1,2,2,2,3,3,3,4,4,4,5,5);
        System.out.println("The number that repeats two times in the array is: " + findTwiceRepeatNumber(numbers));
    }

    private static int findTwiceRepeatNumber(List<Integer> numbers) {
        int n = numbers.size();
        int ans = 0;
        for (int i=0; i<32; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if(isBitSet(numbers.get(j), i)) {
                    count++;
                }
            }
            if ((count%3)==2) {
                ans += (1<<i);
            }
        }
        return ans;
    }

    private static boolean isBitSet(int num, int pos) {
        return (num & (1 << pos)) != 0;
    }
}
