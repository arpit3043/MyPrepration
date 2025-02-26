package BasicAlgorithms.BitsManipulation;
public class BrianKernighanAlgorithm {
    /*
    Given two integers, return the Hamming distance between the two.
    The Hamming distance is the total number of places where the
    corresponding bits are different in the binary representation of two integers.
    */
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        System.out.println(findHammingDistance(x, y));
    }
    private static int findHammingDistance(int x, int y) {
        int count = 0;
        int n = x ^ y;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
