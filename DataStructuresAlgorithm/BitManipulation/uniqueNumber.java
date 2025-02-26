
public class uniqueNumber {
    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 4, 7, 11, 11, 9, 11, 7, 5, 4, 4};
        System.out.println(uniqueRepeatingInThriceRepetitive(arr));
    }

    private static int uniqueRepeatingInThriceRepetitive(int[] arr) {
        int N = arr.length;
        int ans = 0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(checkSetBit(arr[j], i)) {
                    count++;
                }
            }
            if(count%3==1) {
                ans = ans+(1<<i);
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
