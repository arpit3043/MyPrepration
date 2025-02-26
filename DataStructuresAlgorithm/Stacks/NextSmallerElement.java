package Stacks;
import java.lang.String;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class NextSmallerElement {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(2,1,4,3));
        int n= arr.size();
        System.out.println(nextSmallerElement(arr, n));
    }
    private static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        stack.push(-1);
        int[] arr1 = new int[n];
        for (int i=n-1; i>=0; i--) {
            int curr = arr.get(i);
            while (!stack.isEmpty() && curr <= stack.peek()) {
                stack.pop();
            }
            arr1[i] = stack.peek();
            stack.push(curr);
        }
        for (int i = 0; i < n; i++) {
            ans.add(arr1[i]);
        }
        return ans;
    }
}