package BackTracking;
public class KSubSetSumEqualsK {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 4};
        int K = 2;
        System.out.println(splitArray(arr, K));
    }
    private static boolean splitArray(int[] arr, int K) {
        int tsum=0;
        int n=arr.length;
        for(int i:arr) {
            tsum+=i;
        }
        if(tsum<K || tsum%K!=0) {
            return false;
        }
        int div=tsum/K;
        boolean[] vis =new boolean[n];
        return rec(0,div,arr,vis,K,0);
    }

    private static boolean rec(int idx, int div, int[] arr, boolean[] vis, int k, int csum) {
        if(k==0) {
            return true;
        }
        if(csum>div) {
            return false;
        }
        if(csum==div) {
            return rec(0,div,arr,vis,k-1,0);
        }
        for(int i=idx;i<arr.length;i++) {
            if(vis[i]) {
                continue;
            }
            vis[i]=true;
            if(rec (i+1,div,arr,vis,k,csum+arr[i])) {
                return true;
            }
            vis[i]=false;
        }
        return false;
    }
}