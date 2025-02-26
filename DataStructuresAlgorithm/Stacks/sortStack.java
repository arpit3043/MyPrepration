package Stacks;
import java.util.Stack;
public class sortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(1);
        stack.push(6);
        stack = sortStack(stack);
        System.out.println("Sorted Stack:");
        printStack(stack);
    }
    public static Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> stack = new Stack<>();
        if(s.isEmpty()) {
            return s;
        }
        int data = s.peek();
        s.pop();
        s = sortStack(s);
        while(!s.isEmpty() && s.peek()>data) {
            stack.push(s.peek());
            s.pop();
        }
        s.push(data);
        while(!stack.empty()) {
            s.push(stack.peek());
            stack.pop();
        }
        return s;
    }

    private static void printStack(Stack<Integer>stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}