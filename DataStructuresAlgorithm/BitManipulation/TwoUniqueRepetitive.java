
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
public class TwoUniqueRepetitive {
    public static void main(String[] args) throws Exception {
        List<Integer>arr = new ArrayList<>(Arrays.asList(10,8,8,9,12,9,6,11,10,6,12,17));
        System.out.println(twoUniqueRepetitiveElement(arr));
    }

    private static List<Integer>twoUniqueRepetitiveElement(List<Integer>arr) {
        List<Integer>ans = new ArrayList<>();
        int N = arr.size();
        int result = 0;
        int pos = 0;
        int xor1=0;
        int xor2=0;
        for(int i=0; i<N; i++) {
            result = result^arr.get(i);
        }
        for(int i=0; i<32; i++) {
            if(checkSetBit(result, i)) {
                pos=i;
                break;
            }
        }
        for(int i=0; i<N; i++) {
            if(checkSetBit(arr.get(i), pos)) {
                xor2 = xor2^arr.get(i);
            } else {
                xor1 = xor1^arr.get(i);
            }
        }
        ans.add(xor1);
        ans.add(xor2);
        return ans;
    }

    private static boolean checkSetBit(int N, int i) {
        if ((N & (1 << i)) != (1 << i)) {
            return false;
        }
        return true;
    }
}