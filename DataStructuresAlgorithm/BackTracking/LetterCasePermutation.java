package DataStructuresAlgorithm.BackTracking;
import java.util.ArrayList;
import java.util.List;
public class LetterCasePermutation {
    public static void main(String[] args) {
        String input = "a1b2";
        List<String> result = letterCasePermutation(input);
        System.out.println(result);
    }

    private static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        checkString(s, "", 0, ans);
        return ans;
    }

    private static void checkString(String s, String curr, int idx, List<String> ans) {
        if (idx == s.length()) {
            ans.add(curr);
            return;
        }
        char currentChar = s.charAt(idx);
        if (Character.isDigit(currentChar)) {
            checkString(s, curr + currentChar, idx + 1, ans);
        } else {
            checkString(s, curr + Character.toUpperCase(currentChar), idx + 1, ans);
            checkString(s, curr + Character.toLowerCase(currentChar), idx + 1, ans);
        }
    }
}