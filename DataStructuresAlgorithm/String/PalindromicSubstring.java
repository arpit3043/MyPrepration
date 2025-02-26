package String;
public class PalindromicSubstring {
    public static void main(String[] args) {
        String str1="abc";
        String str2="abababab";
        System.out.println(palindromicSubstrings(str1));
        System.out.println(palindromicSubstrings(str2));
    }
    private static int palindromicSubstrings(String str) {
        int N = str.length();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < N && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < N && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}