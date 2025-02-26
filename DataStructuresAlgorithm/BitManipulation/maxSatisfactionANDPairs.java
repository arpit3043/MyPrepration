package BitManipulation;
public class maxSatisfactionANDPairs {
    public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, 15, 4, 14};
        System.out.println(maxANDQuadruplesInArray(arr));
    }
    private static int maxANDQuadruplesInArray(int[] arr) {
        int N = arr.length;
        int ans = 0;
        if(N==4) {
            return (arr[0] & arr[1] & arr[2] & arr[3]);
        } else {
            for(int i=30; i>=0; i--) {
                int count = 0;
                for(int j=0; j<N; j++) {
                    if(checkSetBit(arr[j], i)) {
                        count++;
                    }
                }
                if(count>=4) {
                    ans = ans+(1<<i);
                    for(int j=0; j<N; j++) {
                        if(!checkSetBit(arr[j], i)) {
                            arr[j]=0;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private static boolean checkSetBit(int N, int i) {
        if ((N & (1 << i)) != (1 << i)) {
            return false;
        }
        return true;
    }
}