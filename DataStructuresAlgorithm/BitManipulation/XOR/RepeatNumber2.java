package XOR;
import java.util.*;
public class RepeatNumber2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4);
        
        System.out.println("Single repeating number: " + singleRepeatingNumberInThriceRepetiton(numbers));
    }

    // XOR will not work for odd repetitions
    private static int singleRepeatingNumberInThriceRepetiton(List<Integer>numbers) {
        int n = numbers.size();
        int ans = 0;

        if (numbers.isEmpty()) {
            System.out.println("The list is empty.");
            return -1;
        }

        for (int i = 0; i < 32; i++) { 
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (isBitSet(numbers.get(j), i)) {
                    count++;
                }
            }

            if ((count % 3) == 1) {
                ans += (1 << i); // we can use Math.pow(2, i) instead of 
            }
        }
        return ans;
    }

    private static boolean isBitSet(int num, int i) {
        return (num & (1 << i)) != 0;
    }
}
