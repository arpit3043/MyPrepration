package Stacks;
class Stack {
    int[] s;
    int top;
    Stack(int capacity) {
        s = new int[capacity];
        top = -1;
    }
    public void push(int num) {
        if (top == s.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        ++top;
        s[top] = num;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return s[top--];
    }

    public int top() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return s[top];
    }
    public int isEmpty() {
        return (top == -1) ? 1 : 0;
    }
    public int isFull() {
        return (top == s.length - 1) ? 1 : 0;
    }
}
public class ImplementationOfStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top());
        System.out.println("Is stack empty? " + (stack.isEmpty() == 1));
        System.out.println("Is stack full? " + (stack.isFull() == 0));
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Is stack empty? " + (stack.isEmpty() == 1));
        System.out.println("Is stack full? " + (stack.isFull() == 0));
    }
}