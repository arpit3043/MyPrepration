package Stacks;
import java.util.Stack;
import java.lang.Integer;
public class QueueUsingStack {
    private static class Queue {
        // Define the data members(if any) here.
        Stack<Integer> input;
        Stack<Integer> output;
        Queue() {
            // Initialize your data structure here.
            input=new Stack<>();
            output=new Stack<>();
        }
        void enQueue(int val) {
            // Implement the enqueue() function.
            input.push(val);
        }
        int deQueue() {
            // Implement the dequeue() function.
            if(output.isEmpty()){
                if(input.isEmpty()){
                    return -1;
                }
                while(!input.isEmpty()){
                    output.push(input.peek());
                    input.pop();
                }
            }
            return output.pop();
        }
        int peek() {
            if(output.isEmpty()){
                if(input.isEmpty()){
                    return -1;
                }
                while(!input.isEmpty()){
                    output.push(input.peek());
                    input.pop();
                }
            }
            return output.peek();
        }
        boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}