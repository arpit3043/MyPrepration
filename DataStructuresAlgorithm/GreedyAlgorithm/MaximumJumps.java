package GreedyAlgorithm;
public class MaximumJumps {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        int n = arr.length;
        int jumps = 1;
        int maxrange = arr[0];
        int steps = arr[0];
        if(n==1) {
            return 0;
        }

        if(arr[0]==0) {
            return -1;
        }

        for(int i=1; i<n; i++) {
            if(i==n-1) {
                return jumps;
            }
            maxrange = Math.max(maxrange, i+arr[i]);
            steps--;
            if(steps==0) {
                if(i>=maxrange) {
                    return -1;
                }
                jumps++;
                steps = maxrange-i;
            }
        }
        return -1;
    }
}