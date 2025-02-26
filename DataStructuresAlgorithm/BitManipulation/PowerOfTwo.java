package BitManipulation;
public class PowerOfTwo {
    public static void main(String[] args) {
        int N=16;
        System.out.println(isPowerOfTwo(N));
    }
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
