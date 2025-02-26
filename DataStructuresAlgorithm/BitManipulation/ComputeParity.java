package BitManipulation;
public class ComputeParity {
    public static void main(String[] args) {
        int n = 31;
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        if (findParityOfNumber(n)) {
            System.out.println("The parity of " + n + " is odd");
        }
        else {
            System.out.println("The parity of " + n + " is even");
        }
    }

    private static boolean findParityOfNumber(int n) {
        boolean parity = false;
        while (n != 0) {
            if ((n & 1) != 0) {
                parity = !parity;
            }
            n = n >> 1;
        }
        return parity;
    }
}