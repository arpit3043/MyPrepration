package BitManipulation;
public class BitsNeededToConvertX2Y {
    public static void main(String[] args) throws Exception {
        int x = 65;
        int y = 80;
        System.out.println(x + " in binary is " + Integer.toBinaryString(x));
        System.out.println(y + " in binary is " + Integer.toBinaryString(y));
        System.out.println("\nThe total number of bits to be flipped is " + findBitsToBeConvertedFromX2Y(x, y));
    }
    private static int findBitsToBeConvertedFromX2Y(int x, int y) {
        int n = x ^ y;
        // Using Brian Kernighan’s algorithm to count set bits `count` stores the total bits set in `n`
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}