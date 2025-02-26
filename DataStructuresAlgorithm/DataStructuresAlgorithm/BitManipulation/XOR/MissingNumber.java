package XOR;
// Given an Array of Length N, where all elements are distinct and are in range (1, N+2).
// Find the missing element from the list.

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 6};
        System.out.println(Arrays.toString(MissingPositiveNumber(arr)));
    }

    private static int[] MissingPositiveNumber(int[] arr) {
        int n = arr.length;
        int xorAll = 0;
        int xorArr = 0;
        int xorResult = 0;
        int pos = 0;
        int setBit = 0;
        int unsetBit = 0;
        int[] result = new int[2];
        for (int i = 1; i <= n + 2; i++) {
            xorAll ^= i;
        }
        for (int num : arr) {
            xorArr ^= num;
        }
        xorResult = xorAll ^ xorArr;
        while ((xorResult & (1 << pos)) == 0) {
            pos++;
        }

        for (int i = 1; i <= n + 2; i++) {
            if ((i & (1 << pos)) != 0) {
                setBit ^= i;
            } else {
                unsetBit ^= i;
            }
        }

        for (int num : arr) {
            if (checkSetBit(num, pos)) {
                setBit ^= num;
            } else {
                unsetBit ^= num;
            }
        }

        result[0] = setBit;
        result[1] = unsetBit;
        return result;
    }

    private static boolean checkSetBit(int a, int b) {
        return (a & (1 << b)) != 0;
    }
}
