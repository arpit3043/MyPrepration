package BitManipulation;
public class PositionOfRightMostSetBit {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("The position of the rightmost set bit is " +
                positionOfRightmostSetBit(n));
    }
    private static int positionOfRightmostSetBit(int n) {
        if ((n & 1) != 0) {
            return 1;
        }
        n = n ^ (n & (n - 1));
        int pos = 0;
        while (n != 0) {
            n = n >> 1;
            pos++;
        }
        return pos;
    }
    private static int positionOfRightmostSetBitAlternative(int n) {
        // if the number is odd, return 1
        if ((n & 1) != 0) {
            return 1;
        }
        return log(n & -n, 2) + 1;
    }
    private static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
}