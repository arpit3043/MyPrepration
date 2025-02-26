package Stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;
public class ReversePolishString {
    public static void main(String[] args) throws Exception {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evaluateReversePolishNotation(tokens));
    }
    private static int evaluateReversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>() ;
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/")) ;
        for (String i:tokens) {
            if(!set.contains(i)) {
                stack.push(Integer.valueOf(i));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if(i.equals("+")) {
                    stack.push(a + b);
                } else if(i.equals("-")) {
                    stack.push(b - a);
                } else if(i.equals("*")) {
                    stack.push(a*b);
                } else {
                    stack.push(b/a);
                }
            }
        }
        return stack.peek() ;
    }
}