//package BitManipulation;
import java.io.IOException;;
public class maxANDPairs {
    public static void main(String[] args) throws IOException {
        int[] arr = {26, 13, 23, 28, 27, 7, 25};
        System.out.println(maxANDPairsInArray(arr));
    }

    private static int maxANDPairsInArray(int[] arr) {
        // We will work on MSB of left
        int N = arr.length;
        int ans = 0;
        if(N==2) {
            ans = (arr[0]&arr[1]);
        } else {
            for(int i=31; i>0; i--) {
                int count = 0;
                for(int j=0; j<N; j++) {
                    if(checkSetBit(arr[j], i)) {
                        count++;
                    }
                }
                if(count>=2) {
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
