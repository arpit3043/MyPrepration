package DynamicProgramming.Maths;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) throws Exception {
        int n = 5;
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        Arrays.fill(dp, -1);
        if(dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }
}
