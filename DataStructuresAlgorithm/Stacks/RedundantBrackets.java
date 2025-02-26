package Stacks;
import java.util.Stack;
import java.lang.Character;
import java.lang.String;
public class RedundantBrackets {
    public static void main(String[] args) {
        String s="(c+(a+b)*(c/d)-(a+c))";
        System.out.println(findRedundantBrackets(s));
    }
    private static boolean findRedundantBrackets(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')' && !brackets.isEmpty()) {
                boolean hasOperator = false;
                while (!brackets.isEmpty() && brackets.peek() != '(') {
                    char top = brackets.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }
                if (!hasOperator) {
                    return true;
                }
                brackets.pop(); // Remove '('
            } else if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                brackets.push(ch);
            }
        }
        return false;
    }
}