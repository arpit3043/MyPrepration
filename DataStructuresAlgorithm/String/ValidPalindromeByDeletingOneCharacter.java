package String;
public class ValidPalindromeByDeletingOneCharacter {
    public static void main(String[] args) {
        String str = "abca";
        System.out.println(validPalindromeAfterDeletingOneCharacter(str));
    }

    private static boolean validPalindromeAfterDeletingOneCharacter(String str) {
        int N = str.length();
        int s = 0;
        int e = N - 1;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                return isPalindrome(str, s + 1, e) || isPalindrome(str, s, e - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}