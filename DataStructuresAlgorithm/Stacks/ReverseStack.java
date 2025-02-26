package Stacks;
import java.util.Queue;
import java.util.LinkedList;
public class ReverseStack {
    public static void main(String[] args) {
        Queue<Integer> originalQueue = new LinkedList<>();
        originalQueue.add(1);
        originalQueue.add(2);
        originalQueue.add(3);
        System.out.println("Original Queue: " + originalQueue);
        Queue<Integer> reversedQueue = reverseQueue(originalQueue);
        System.out.println("Reversed Queue: " + reversedQueue);
    }
    private static Queue<Integer> reverseQueue(Queue<Integer>q) {
        reverseQueueHelper(q);
        return q;
    }
    private static void reverseQueueHelper(Queue<Integer> q) {
        if(q.isEmpty()) {
            return;
        }
        int val=q.peek();
        q.poll();
        reverseQueueHelper(q);
        q.add(val);
    }
}