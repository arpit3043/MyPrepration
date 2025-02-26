package Stacks;
import java.util.Stack;
import java.lang.Character;
public class minimumParenthesis {
    public static void main(String[] args) throws Exception {
        String pattern = ")((()";
        System.out.println(minimumParentheses(pattern));
    }

    private static int minimumParentheses(String pattern) {
        int N = pattern.length();
        Stack<Character>stack = new Stack<>();
        for(int i=0; i<N; i++) {
            if(pattern.charAt(i) == '(') {
                stack.push(pattern.charAt(i));
            } else if(pattern.charAt(i)==')' &&
                    !stack.empty() &&
                    stack.peek()=='(') {
                stack.pop();
            } else {
                stack.push(pattern.charAt(i));
            }
        }
        if(stack.empty()) {
            return 0;
        }
        return stack.size();
    }
}