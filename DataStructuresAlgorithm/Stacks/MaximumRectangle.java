package Stacks;
import java.util.Stack;
public class MaximumRectangle {
    public static void main(String[] args) throws Exception {
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        int N=mat.length;
        int M=mat[0].length;
        System.out.println(maximumAreaOfRectangle(mat, N, M));
    }
    private static int maximumAreaOfRectangle(int[][] M, int n, int m) {
        int maxi = Integer.MIN_VALUE;
        int[] histogram = new int[m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(M[i][j]==1) {
                    histogram[j]++;
                } else {
                    histogram[j]=0;
                }
            }
            maxi = Math.max(maxi, largestAreaInHistogram(histogram));
        }
        return maxi;
    }

    private static int largestAreaInHistogram(int[] arr) {
        int N = arr.length;
        int ans = 0;
        int[] NSEL = nextSmallerElementToLeft(arr, N);
        int[] NSER = nextSmallerElementToRight(arr, N);
        for(int i=0; i<N; i++) {
            int area = arr[i] * Math.abs(NSER[i] - NSEL[i] - 1);
            ans = Math.max(area, ans);
        }
        return ans;
    }

    private static int[] nextSmallerElementToLeft(int[] arr, int N) {
        Stack<Integer>stack = new Stack<>();
        int[] ans = new int[N];
        for(int i=0; i<N; ++i) {
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerElementToRight(int[] arr, int N) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        for(int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = N;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}