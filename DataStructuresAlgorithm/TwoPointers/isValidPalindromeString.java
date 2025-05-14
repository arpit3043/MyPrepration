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
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !isAlphaNum(s.charAt(start))) {
                start++;
            }
            while (end > start && !isAlphaNum(s.charAt(end))) {
                end--;
            }
            if (toLowerCase(s.charAt(start)) != toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isAlphaNum(char c) {
        return isAlphabet(c) || isDigit(c);
    }

    private static boolean isAlphabet(char c) {
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < alphabets.length(); i++) {
            if (c == alphabets.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDigit(char c) {
        String digits = "0123456789";
        for (int i = 0; i < digits.length(); i++) {
            if (c == digits.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static char toLowerCase(char c) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            if (c == upper.charAt(i)) {
                return lower.charAt(i);
            }
        }
        return c;
    }
}