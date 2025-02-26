package String;
import java.lang.String;
public class AddStrings {
    public static void main(String[] args) throws Exception {
        String str1 = "111";
        String str2 = "222";
        System.out.println(addStrings(str1, str2));
    }
    private static String addStrings(String num1, String num2) {
        String result = "";
        int N = num1.length();
        int M = num2.length();
        int carry = 0;
        int i = N - 1;
        int j = M - 1;
        int digit1 = 0;
        int digit2 = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                digit1 = num1.charAt(i) - '0';
            } else {
                digit1 = 0;
            }
            if (j >= 0) {
                digit2 = num2.charAt(j) - '0';
            } else {
                digit2 = 0;
            }
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result = String.valueOf(sum % 10) + result;
            i--;
            j--;
        }
        return result;
    }
}