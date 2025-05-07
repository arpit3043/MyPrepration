package Recursion;

public class MinimumPerfectSquareSumRecursion {
    public static void main(String[] args) throws Exception {
        int n = 12; // Example input
        System.out.println(minPerfectSquareSumRecursive(n)); // Output: 3 (4 + 4 + 4)
    }

    private static int minPerfectSquareSumRecursive(int n) {
        int smallestPerfectSquare = Integer.MAX_VALUE;
        if(n == 0 || n == 1) {
            return n;
        }
        for(int i = 1; i <= Math.sqrt(n); i++) {
            int recursiveCall = minPerfectSquareSumRecursive(n - (int)Math.pow(i, 2));
            smallestPerfectSquare = Math.min(smallestPerfectSquare, recursiveCall);
        }
        return smallestPerfectSquare + 1;
    }
}
