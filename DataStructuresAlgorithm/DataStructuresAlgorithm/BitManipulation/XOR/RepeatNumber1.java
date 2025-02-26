package XOR;
import java.util.*;

class RepeatNumber1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 3, 2, 4, 1, 3, 2);
        System.out.println("Single repeating number: " + singleRepeatingNumber(numbers));
    }
    
    // Using XOR operation to find the repeating number
    private static int singleRepeatingNumber(List<Integer> numbers) {
        int n = numbers.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ numbers.get(i);
        }
        return ans;
    }
}