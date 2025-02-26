package Stacks;
import java.util.Stack;
import java.lang.Character;
import java.lang.String;
import java.lang.StringBuilder;
public class InfixToPostFix {
    public static void main(String[] args) {
        String equation = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(InfinixToPostFix(equation));
    }
    private static String InfinixToPostFix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <infix.length() ; i++) {
            char c = infix.charAt(i);
            if(precedence(c)>0) {
                while(!stack.isEmpty() && precedence(stack.peek())>=precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            } else if(c==')') {
                char x = stack.pop();
                while(x!='(') {
                    result.append(x);
                    x = stack.pop();
                }
            } else if(c=='(') {
                stack.push(c);
            } else {
                result.append(c);
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}