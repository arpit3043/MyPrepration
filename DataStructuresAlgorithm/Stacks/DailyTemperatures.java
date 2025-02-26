package Stacks;
import java.lang.String;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Stack;
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    private static int[] dailyTemperatures(int[] temperatures) {
        int N=temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        for (int i=N-1; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return ans;
    }
}