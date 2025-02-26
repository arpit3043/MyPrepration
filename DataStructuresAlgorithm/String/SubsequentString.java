package String;
public class SubsequentString {
    public static void main(String[] args) {
        String first = "abcde";
        String second = "abd";
        if (isSubsequenceString(first, second)) {
            System.out.println("Subsequence found");
        } else {
            System.out.println("Not a subsequence");
        }
    }
    private static boolean isSubsequenceString(String first, String second) {
        if (second.isEmpty()) {
            return true;
        }
        int i = 0;
        for (char c: first.toCharArray()) {
            if (c == second.charAt(i)) {
                if (++i == second.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
