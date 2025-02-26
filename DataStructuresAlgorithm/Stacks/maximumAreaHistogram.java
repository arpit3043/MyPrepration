package Stacks;

import java.util.Stack;
import java.lang.Integer;
import java.lang.String;

public class maximumAreaHistogram {

    public static void main(String[] args) throws Exception {
        int[] height = {2, 1, 5, 6, 2, 3};
        int N = height.length;
        System.out.println(largestAreaInHistogram(height, N));
    }

    private static int largestAreaInHistogram(int[] arr, int N) {
        int[] NSEL = nextSmallerElementToLeft(arr, N);
        int[] NSER = nextSmallerElementToRight(arr, N);
        int ans = 0;
        for(int i=0; i<N; i++) {
            int area = arr[i] * Math.abs(NSER[i] - NSEL[i] - 1);
            ans = Math.max(area, ans);
        }
        return ans;
    }

    private static int[] nextSmallerElementToLeft(int[] arr, int N) {
        Stack<Integer>stack = new Stack<>();
        int[] ans = new int[N];
        for(int i=0; i<N; ++i) {
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerElementToRight(int[] arr, int N) {
        Stack<Integer>stack = new Stack<>();
        int[] ans = new int[N];
        for(int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = N;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}