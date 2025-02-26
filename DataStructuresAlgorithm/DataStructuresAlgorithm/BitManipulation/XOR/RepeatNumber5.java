package XOR;
// every element in the array repeats two times except the two elements which are unique in the array

import java.util.Arrays;

public class RepeatNumber5 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 4, 3, 8};
        System.out.println(Arrays.toString(findTwoUniqieElements(arr)));
    }

    private static int[] findTwoUniqieElements(int[] arr) {
        int[] result = new int[2];
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        int pos = 0;
        for(int i=0; i<32; i++) {
            if(checkSetBit(xor, i)==true) {
                pos = i;
                break;
            }
        }
        int setBit=0;
        int unsetBit=0;
        for(int num: arr) {
            if(checkSetBit(num, pos)==true) {
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
