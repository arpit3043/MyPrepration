package Stacks;
import java.util.Stack;
import java.lang.String;
import java.lang.Character;
import java.lang.StringBuilder;
public class ReverseString {
    public static void main(String[] args) throws Exception {
        String S="GeeksforGeeks";
        System.out.println(reverseAString(S));
    }
    private static String reverseAString(String S) {
        Stack<Character>stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int length = S.length();
        for(int i = 0; i<S.length(); i++) {
            stack.push(S.charAt(i));
        }
        for(int i = length; i>0; i--) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}