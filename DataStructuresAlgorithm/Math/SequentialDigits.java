package Math;
import java.util.ArrayList;
import java.util.List;
public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1000;
        int high = 13000;
        System.out.println(sequentialDigits(low, high));
    }

    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            int nextDigit = i + 1;
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit;
                if (low <= num && num <= high) {
                    a.add(num);
                }
                ++nextDigit;
            }
        }
        a.sort(null);
        return a;
    }
}