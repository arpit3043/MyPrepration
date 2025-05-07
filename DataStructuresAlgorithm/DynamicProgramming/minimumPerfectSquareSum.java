package DynamicProgramming;

public class minimumPerfectSquareSum {
    public static void main(String[] args) throws Exception {
        int n = 12;
        System.out.println(minPerfectSquareSum(n));
    }

    private static int minPerfectSquareSum(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(j, 2)] + 1);
            }
        }
        return dp[n];
    }
}
