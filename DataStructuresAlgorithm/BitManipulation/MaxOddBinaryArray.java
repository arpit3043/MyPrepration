package BitManipulation;
import java.lang.String;
public class MaxOddBinaryArray {
    public static void main(String[] args) {
        String s = "0101";
        System.out.println(maximumOddBinaryNumber(s));
    }

    private static String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '1') {
                count++;
            }
        }
        arr[n - 1] = '1';
        count--;
        for (int i = 1; i <= count; i++) {
            arr[j] = '1';
            j++;
        }
        for (int i = j; i < n - 1; i++) {
            arr[i] = '0';
        }
        return String.valueOf(arr);
    }
}