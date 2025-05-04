package Arrays.PrefixSum;
public class TrappingRainWater {
    public static void main(String[] args) throws Exception {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int N = arr.length;
        System.out.println(maximumRainWaterTrapped(arr, N));
    }

    private static int maximumRainWaterTrapped(int[] arr, int N) {
        int maximumAmountOfWater = 0;
        int[] leftBlocked = prefixMax(arr, N);
        int[] rightBlocked = suffixMax(arr, N);
        for(int i=1; i<N-1; i++) {
            int totalBlockedWater = Math.min(leftBlocked[i], rightBlocked[i]);
            int amountOfWaterBlocked = totalBlockedWater-arr[i];
            if(amountOfWaterBlocked>0) {
                maximumAmountOfWater = maximumAmountOfWater + amountOfWaterBlocked;
            }
        }
        return maximumAmountOfWater;
    }

    private static int[] suffixMax(int[] arr, int N) {
        int[] ans = new int[N];
        ans[N-1] = arr[N-1];
        for(int i=N-2; i>=0; i--) {
            ans[i] = Math.max(arr[i], ans[i+1]);
        }
        return ans;
    }
    
    private static int[] prefixMax(int[] arr, int N) {
        int[] ans = new int[N];
        ans[0] = arr[0];
        for(int i=1; i<N; i++) {
            ans[i] = Math.max(arr[i], ans[i-1]);
        }
        return ans;
    }
}