package Stacks;

import java.util.Stack;

public class PostFixExpression {
    public static void main(String[] args) {
        String exp = "138*+";
        System.out.println(evalPostfix(exp));
    }
    private static int evalPostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        if (exp == null || exp.isEmpty()) {
            System.exit(-1);
        }
        for (char c: exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int x = stack.pop();
                int y = stack.pop();
                if (c == '+') {
                    stack.push(y + x);
                } else if (c == '-') {
                    stack.push(y - x);
                } else if (c == '*') {
                    stack.push(y * x);
                } else if (c == '/') {
                    stack.push(y / x);
                }
            }
        }
        return stack.pop();
    }
}