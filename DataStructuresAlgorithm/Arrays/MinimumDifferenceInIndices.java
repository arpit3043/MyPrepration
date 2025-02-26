package Arrays;
public class MinimumDifferenceInIndices {
    public static void main(String[] args) throws Exception {
        int[] A = {1, 3, 5, 4, 8, 2, 4, 3, 6, 5};
        int x = 2;
        int y = 5;
        int diff = findMinDifference(A, x, y);
        if (diff != Integer.MAX_VALUE) {
            System.out.print("The minimum difference is -> " + diff);
        } else {
            System.out.print("Invalid input");
        }
    }
    private static int findMinDifference(int[] A, int x, int y) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }
        int xIndex = n;
        int yIndex = n;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] == x) {
                xIndex = i;
                if (yIndex != n) {
                    minDiff = Integer.min(minDiff, Math.abs(xIndex - yIndex));
                }
            }
            if (A[i] == y) {
                yIndex = i;
                if (xIndex != n) {
                    minDiff = Integer.min(minDiff, Math.abs(xIndex - yIndex));
                }
            }
        }
        return minDiff;
    }
}