package XOR;
// given an array, calculate sum of xor of all pairs of arrays using contributions technique of Bits Manipulation

class SumOfXORPairs {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 8, 2};
        System.out.println(sumOfAllXORPairs(arr));
    }

    private static int sumOfAllXORPairs(int[] arr) {
        int sum = 0;
        int n = arr.length;

        // Iterate through each bit position (0 to 31 for 32-bit integers)
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            // Count how many numbers have the i-th bit set
            for (int j = 0; j < n; j++) {
                if (checkSetBit(arr[j], i)) {
                    count++;
                }
            }
            
            // For each pair of different bits, we have two contributions
            // Each pair of different bits (one having the i-th bit set and the other not)
            // will contribute twice the value of 2^i to the sum (since (i, j) and (j, i) are distinct)
            sum += 2 * count * (n - count) * (1 << i);
        }
        // Return the final computed sum after processing all bit positions
        return sum;  // This should be outside the loop
    }

    // Helper function to check if the b-th bit of number a is set
    private static boolean checkSetBit(int a, int b) {
        return (a & (1 << b)) != 0;
    }
}
