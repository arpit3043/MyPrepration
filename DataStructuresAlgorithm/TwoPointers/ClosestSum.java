package TwoPointers;
public class ClosestSum {
    public static void main(String[] args) {

    }
    private static int[] closestSumArray(int[] A, int[] B, int C) {
        int[] ans = new int[2];
        int minDiff = Integer.MAX_VALUE;
        int n = A.length;
        int m = B.length;
        int left = 0;
        int right = m - 1;
        int updatedLeft = -1;
        int updatedRight = -1;
        while (left < n && right >= 0) {
            int currentDiff = Math.abs(A[left] + B[right] - C);
            if (currentDiff == minDiff) {
                if (A[left] == A[updatedLeft]) {
                    updatedRight = right;
                }
            } else if (currentDiff < minDiff) {
                minDiff = currentDiff;
                updatedLeft = left;
                updatedRight = right;
            }
            if (A[left] + B[right] > C) {
                right--;
            } else {
                left++;
            }
        }
        ans[0] = A[updatedLeft];
        ans[1] = B[updatedRight];
        return ans;
    }
}