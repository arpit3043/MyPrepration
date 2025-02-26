package Stacks;
import java.util.Stack;
import java.lang.Integer;
import java.lang.String;
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void push(int x) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    public int pop() {
        return s1.pop();
    }
    public int peek() {
        return s1.peek();
    }
    public boolean empty() {
        return s1.isEmpty();
    }
}

public class QueueImplementation {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("Output: " + myQueue);
        myQueue.push(1);
        System.out.println("Output: " + null);
        myQueue.push(2);
        System.out.println("Output: " + null);
        int param_3 = myQueue.peek();
        System.out.println("Output: " + param_3);
        int param_2 = myQueue.pop();
        System.out.println("Output: " + param_2);
        boolean param_4 = myQueue.empty();
        System.out.println("Output: " + param_4);
    }
}