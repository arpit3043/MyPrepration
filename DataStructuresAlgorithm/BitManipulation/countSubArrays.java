package BitManipulation;
import java.util.HashMap;
import java.util.Map;
public class countSubArrays {
    public static void main(String[] args) {
        int[] a = {1,1,0,0,0,1,0,1,0,0};
        int B = 0;
        int ans = subarraysWithXorB(a, B);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }

    private static int subarraysWithXorB(int []A, int B) {
        int N=A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < N; i++) {
            xor = xor^A[i];
            int x = xor ^ B;
            count += map.getOrDefault(x, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}