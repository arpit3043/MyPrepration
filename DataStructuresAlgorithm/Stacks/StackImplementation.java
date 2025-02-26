package Stacks;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Integer;
public class StackImplementation {
    public static class Stack {
        Queue<Integer>queue1;
        Queue<Integer>queue2;
        public Stack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }
        public int getSize() {
            return queue1.size()+queue2.size();
        }
        public boolean isEmpty() {
            return (queue2.isEmpty() && queue1.isEmpty());
        }
        public void push(int element) {
            queue2.add(element);
            while(!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            Queue<Integer>queue =queue1;
            queue1=queue2;
            queue2=queue;
        }
        public int pop() {
            if(queue1.isEmpty()) {
                return -1;
            }
            return queue1.poll();
        }
        public int top() {
            if(queue1.isEmpty()) {
                return -1;
            }
            return queue1.peek();
        }
    }
}