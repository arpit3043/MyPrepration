package BitManipulation;
import java.util.ArrayList;
import java.util.List;
public class MissingTwoNumbers {
    public static void main(String[] args) throws Exception {
        int[] arr = {5,1,3,6};
        System.out.println(missingTwoNumbersInArray(arr));
    }
    private static List<Integer>missingTwoNumbersInArray(int[] arr) {
        List<Integer>ans = new ArrayList<>();
        int N = arr.length;
        int result = 0;
        int pos = 0;
        int xor1=0;
        int xor2=0;
        for(int i=0; i<N; i++) {
            result = result^arr[i];
        }
        for(int i=1; i<=N+2; i++) {
            result = result^i;
        }
        for(int i=0; i<32; i++) {
            if(checkSetBit(result, i)) {
                pos=i;
                break;
            }
        }
        for(int i=0; i<N; i++) {
            if(checkSetBit(arr[i], pos)==true) {
                xor2 = xor2^arr[i];
            } else {
                xor1 = xor1^arr[i];
            }
        }
        for(int i=1; i<=N+2; i++) {
            if(checkSetBit(i, pos)==true) {
                xor2 = xor2^i;
            } else {
                xor1 = xor1^i;
            }
        }
        ans.add(xor1);
        ans.add(xor2);
        return ans;
    }
    private static boolean checkSetBit(int N, int i) {
        if ((N | (1<<i))==N) {
            return true;
        }
        return false;
    }
}