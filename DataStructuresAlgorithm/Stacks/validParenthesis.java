package Stacks;
import java.util.Stack;
import java.lang.Character;
public class validParenthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValidParenthesis(s));
    }
    private static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                return false;
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                        stack.pop();
                    } else {
                        stack.add(s.charAt(i));
                    }
                } else {
                    stack.add(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}