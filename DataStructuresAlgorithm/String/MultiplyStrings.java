package String;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Integer;
public class MultiplyStrings {
    public static void main(String[] args) throws Exception {
        String a="123";
        String b="456";
        System.out.println(multiplyStrings(a, b));
    }
    private static String multiplyStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] ans = new int[n + m];
        StringBuilder sb = new StringBuilder();
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        if (n == 1 && num1.charAt(0) == '0') {
            return "0";
        }
        if (m == 1 && num2.charAt(0) == '0') {
            return "0";
        }
        if (n == 1 && num1.charAt(0) == '1') {
            return num2;
        }
        if (m == 1 && num2.charAt(0) == '1') {
            return num1;
        }
        for (int i = n - 1; i >= 0; i--) {
            nums1.add(num1.charAt(i) - '0');
        }
        for (int i = m - 1; i >= 0; i--) {
            nums2.add(num2.charAt(i) - '0');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i + j] = ans[i + j] + (nums1.get(i) * nums2.get(j));
                ans[i + j + 1] = ans[i + j + 1] + ans[i + j] / 10;
                ans[i + j] = ans[i + j] % 10;
            }
        }
        for (int i = n + m - 1; i >= 0; i--) {
            sb.append(ans[i]);
        }
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}