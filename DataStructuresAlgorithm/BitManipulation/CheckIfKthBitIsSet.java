package BitManipulation;
public class CheckIfKthBitIsSet {
    public static void main(String[] args) {
        int n = 20;
        int k = 3;
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        if (isKthBitSet(n, k)) {
            System.out.println("k'th bit is set");
        } else {
            System.out.println("k'th bit is not set");
        }
    }
    private static boolean isKthBitSet(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }
}