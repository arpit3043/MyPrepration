package Stacks;
import java.util.Stack;
public class SpecialStack {
    Stack<Integer> stack = new Stack<>();
    int mini;
    void push(int data) {
        // Implement the push() function.
        if(stack.isEmpty()) {
            stack.push(data);
            mini = data;
        } else {
            if(data<mini) {
                stack.push(2*data-mini);
                mini=data;
            } else {
                stack.push(data);
            }
        }
    }
    void pop() {
        // Implement the pop() function.
        if(stack.isEmpty()) {
            return;
        }
        int curr=stack.peek();
        if(curr<mini) {
            mini=2*mini-curr;
            stack.pop();
        } else {
            stack.pop();
        }
    }
    int top() {
        // Implement the top() function.
        if(stack.isEmpty()) {
            return -1;
        }
        int curr=stack.peek();
        if(curr<mini) {
            return mini;
        } else {
            return curr;
        }
    }
    int getMin() {
        // Implement the getMin() function.
        return mini;
    }
};