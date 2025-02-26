package XOR;
// every element in the array repeats four times except the one element which repeats twice in the array
public class RepearNumber4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(findRepeatTwiceNumber(arr));
    }
    private static int findRepeatTwiceNumber(int[] arr) {
        int n=arr.length;
        int ans=0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(checkSetBit(arr[j],i)) {
                    count++;
                }
            }
            if(count%4==2) {
                ans |= (1<<i);
            }
        }
        return ans;
    }

    private static boolean checkSetBit(int a, int b) {
        return (a & (1 << b)) != 0;
    }
}
