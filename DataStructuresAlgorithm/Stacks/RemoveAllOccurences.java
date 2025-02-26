package Stacks;
import java.util.Stack;
import java.lang.Character;
import java.lang.String;
import java.lang.StringBuilder;
public class RemoveAllOccurences {
    public static void main(String[] args) throws Exception {
        String s = "axxxxyyyyb";
        String part = "xy";
        System.out.println(removeOccurrences(s, part));
    }

    private static String removeOccurrences(String s, String part) {
        int N1 = s.length();
        int N2 = part.length();
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N1; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= N2 && stack.peek() == part.charAt(N2 - 1)) {
                StringBuilder temp = new StringBuilder();
                boolean isMatch = true;
                for (int j = 0; j < N2; j++) {
                    if (stack.peek() != part.charAt(N2 - 1 - j)) {
                        isMatch = false;
                        break;
                    }
                    temp.append(stack.pop());
                }
                if (!isMatch) {
                    for (int k = temp.length() - 1; k >= 0; k--) {
                        stack.push(temp.charAt(k));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}