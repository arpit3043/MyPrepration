
public class uniqueRepetitiveExceptTwo {
    public static void main(String[] args) throws Exception {
        int[] arr = {5, 4, 3, 2, 5, 4, 3, 2, 5, 4, 3, 2, 5, 4, 3, 2, 6, 6};
        System.out.println(uniqueRepeatingElementTwiceInQuadRepetitive(arr));
    }

    private static int uniqueRepeatingElementTwiceInQuadRepetitive(int[] arr) {
        int N = arr.length;
        int ans = 0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(checkSetBit(arr[j], i)) {
                    count++;
                }
            }
            if(count%4==2) {
                ans = ans+(1<<i);
            }
        }
        return ans;
    }

    private static boolean checkSetBit(int N, int i) {
        if ((N & (1 << i)) == 0) {
            return false;
        }
        return true;
    }
}