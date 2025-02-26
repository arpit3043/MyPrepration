package Math;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    private static int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i]<9) {
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}