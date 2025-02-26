package String;
public class CheckPalindromeString {
    public static void main(String[] args) {
        String str="N2 i&nJA?a& jnI2n";
        System.out.println(checkPalindrome(str));
    }
    private static boolean checkPalindrome(String str) {
        int n = str.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (!isalnum(str.charAt(i)) && i < n) {
                i++;
            }
            while (!isalnum(str.charAt(j))) {
                j--;
            }
            if (Character.toUpperCase(str.charAt(i)) == str.charAt(i)) {
                str = replaceCharAt(str, i, Character.toLowerCase(str.charAt(i)));
            }
            if (Character.toUpperCase(str.charAt(j)) == str.charAt(j)) {
                str = replaceCharAt(str, j, Character.toLowerCase(str.charAt(j)));
            }
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isalnum(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    private static String replaceCharAt(String str, int index, char replacement) {
        if (index < 0 || index >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replacement;
        return new String(chars);
    }
}