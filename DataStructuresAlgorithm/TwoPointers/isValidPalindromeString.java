package TwoPointers;
import java.lang.String;
public class isValidPalindromeString {
    public static void main(String[] args) throws Exception {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));
        String s2 = "0P";
        System.out.println(isPalindrome(s2));
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (isLetterOrDigit(currFirst)) {
                start++;
            } else if (isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (toLowerCase(currFirst) != toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + ('a' - 'A'));
        }
        return c;
    }
}