
public class uniqueNumberExtension {
    public static void main(String[] args) throws Exception {
        int[] arr = {5, 7, 5, 4, 7, 11, 11, 9, 11, 7, 5, 4, 4, 9};
        System.out.println(uniqueRepeatingElementTwiceInThriceRepetitive(arr));
    }

    private static int uniqueRepeatingElementTwiceInThriceRepetitive(int[] arr) {
        int N = arr.length;
        int ans = 0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(checkSetBit(arr[j], i)) {
                    count++;
                }
            }
            if(count%3==2) {
                ans = ans+(1<<i);
            }
        }
        return ans;
    }

    private static boolean checkSetBit(int N, int i) {
        if ((N | (1<<i))==N) {
            return true;
        }
        return false;
    }
}
