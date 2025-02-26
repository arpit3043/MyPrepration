package String;
import java.lang.String;
import java.lang.StringBuilder;
public class reverseOnlyLetters {
    public static void main(String[] args) throws Exception {
        String s = "Qedo1ct-eeLg=ntse-T!";
        System.out.println(reverseOnlyLetters(s));
    }

    private static String reverseOnlyLetters(String s) {
        int N = s.length();
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < N; i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                ans.append(s.charAt(i));
            }
        }
        reverseStr(ans);
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < N; i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                result.setCharAt(i, ans.charAt(j));
                j++;
            }
        }
        return result.toString();
    }

    private static void reverseStr(StringBuilder str) {
        int N = str.length();
        int s = 0;
        int e = N - 1;
        while (s <= e) {
            swap(str, s, e);
            s++;
            e--;
        }
    }

    private static void swap(StringBuilder str, int s, int e) {
        char temp = str.charAt(s);
        str.setCharAt(s, str.charAt(e));
        str.setCharAt(e, temp);
    }
}