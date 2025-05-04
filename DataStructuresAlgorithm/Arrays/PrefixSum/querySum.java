package Arrays.PrefixSum;
public class querySum {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 3, 4, 0, 0, 3, 2, 0};
        int[][] queries = {
            {2, 3, 3},
            {4, 6, 3},
            {7, 7, -4},
            {2, 7, 6}
        };
        int[] ans = carryForwardQuerySum(arr.length, queries);
        printArray(ans);
    }
    
    private static int[] carryForwardQuerySum(int N, int[][] queries) {
        int[] ans = new int[N];
        for (int i = 0; i < queries.length; i++) {
            int sIdx = queries[i][0] - 1;
            int eIdx = queries[i][1];
            int val = queries[i][2];
            for (int j = sIdx; j < eIdx; j++) {
                ans[j] = ans[j] + val;
            }
        }
        return ans;
    }
    private static void printArray(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}