package GreedyAlgorithm;
public class maximumValueOfGivenIndexInBoundedArray {
    public static void main(String[] args) throws Exception {
        int n = 6;
        int index = 1;
        int maxSum = 10;
        System.out.println(maxValue(n, index, maxSum));
    }
    public static int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, index, n) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }
    private static long check(long a, int index, int n) {
        long leftOffset = Math.max(a - index, 0);
        long result = (a + leftOffset) * (a - leftOffset + 1) / 2;
        long rightOffset = Math.max(a - ((n - 1) - index), 0);
        result += (a + rightOffset) * (a - rightOffset + 1) / 2;
        return result - a;
    }
}