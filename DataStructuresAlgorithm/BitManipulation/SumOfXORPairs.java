package BitManipulation;
public class SumOfXORPairs {
    // contribution technique on Bits
    public static void main(String[] args) throws Exception {
        int[] arr = {1,5,6};
        System.out.println(sumOfXORofAllSumPairs(arr));
    }
    
    private static int sumOfXORofAllSumPairs(int[] arr) {
        int xoR = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            xoR = xoR ^ arr[i];
        }
        return xoR * 2;
    }
}