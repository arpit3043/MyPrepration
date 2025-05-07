package DynamicProgramming.Maths;

import java.util.Arrays;

public class WaysToCrossStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(waysToCrossStairs(n));
        System.out.println(waysToCrossStairsIterative(n));
    }

    private static int waysToCrossStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = waysToCrossStairs(n - 1) + waysToCrossStairs(n - 2);
        return dp[n];
    }

    private static int waysToCrossStairsIterative(int n) {
        int a = 1;
        int b = 2;

        if(n==1) {
            return 1;
        }
        
        for(int i=2; i<n; i++) {
            int temp = b;
            b = a+b;
            a = temp;
        }
        return b;
    }
}
