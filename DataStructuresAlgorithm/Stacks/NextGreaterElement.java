package Stacks;
import java.util.Arrays;
import java.util.Stack;
import java.lang.Integer;
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElementToRight(arr)));
    }

    private static int[] nextGreaterElementToRight(int[] arr) {
        int N = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                ans[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;
    }
}