package Stacks;
import java.util.Arrays;
import java.util.List;
class Stack1 {
    private int[] arr;
    private int capacity;
    private int top1, top2;
    public Stack1(int n) {
        capacity = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }
    public void pushFirst(int key) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            System.exit(-1);
        }
        top1++;
        arr[top1] = key;
    }
    public void pushSecond(int key) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            System.exit(-1);
        }
        top2--;
        arr[top2] = key;
    }
    public int popFirst() {
        if (top1 < 0) {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
        int top = arr[top1];
        top1--;
        return top;
    }
    public int popSecond() {
        if (top2 >= capacity) {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
        int top = arr[top2];
        top2++;
        return top;
    }
}
public class ImplementTwoStacksUsingArray {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
        Stack1 stack = new Stack1(list1.size() + list2.size());
        for (int i: list1) {
            stack.pushFirst(i);
        }
        for (int j: list2) {
            stack.pushSecond(j);
        }
        System.out.println("Popping element from the first stack: " + stack.popFirst());
        System.out.println("Popping element from the second stack: " + stack.popSecond());
    }
}