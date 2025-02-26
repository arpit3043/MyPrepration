package Stacks;

import java.util.Stack;
import java.lang.Integer;
import java.lang.String;

public class TrappingRainWater {
    public static void main(String[] args) throws Exception {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWater(height1));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trappingRainWater(height2));
    }

    private static int trappingRainWater(int[] height) {
        int N = height.length;
        int[] NSEL = nextGreaterElementToLeft(height, N);
        int[] NSER = nextGreaterElementToRight(height, N);
        int totalWater = 0;
        if (N <= 2) {
            return 0;
        }

        for (int i = 0; i < N; i++) {
            int minMax = Math.min(NSEL[i], NSER[i]);
            totalWater += minMax - height[i];
        }
        return totalWater;
    }

    private static int[] nextGreaterElementToLeft(int[] arr, int N) {
        Stack<Integer> stack = new Stack<>();
        int[] NSL = new int[N];
        stack.push(0); // Index of the first element
        NSL[0] = -1; // There's no greater element to the left of the first element

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = -1; // No greater element to the left
            } else {
                NSL[i] = stack.peek();
            }
            stack.push(i);
        }
        return NSL;
    }

    private static int[] nextGreaterElementToRight(int[] arr, int N) {
        Stack<Integer> stack = new Stack<>();
        int[] NSR = new int[N];
        stack.push(N - 1); // Index of the last element
        NSR[N - 1] = -1; // There's no greater element to the right of the last element

        for (int i = N - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = -1; // No greater element to the right
            } else {
                NSR[i] = stack.peek();
            }
            stack.push(i);
        }
        return NSR;
    }
}