package String;
public class MaximumCountZeroOne {
    public static void main(String[] args) {
        String S = "0111100010";
        System.out.println(maximumSubString01(S));
    }
    /**
     * The Time complexity of the code is O(N+N) & Space Complexity is O(1)
     * */
    private static int maximumSubString01(String str) {
        int n=str.length();
        int count=0;
        int count0=0;
        int count1=0;
        int sum0=0;
        int sum1=0;
        for(int i=0; i<n; i++) {
            if(str.charAt(i)=='0') {
                count0++;
            }
            if(str.charAt(i)=='1') {
                count1++;
            }
        }
        if(count0==count1) {
            for(int i=0; i<n; i++) {
                if(str.charAt(i)=='0') {
                    sum0++;
                }
                if(str.charAt(i)=='1') {
                    sum1++;
                }
                if(sum0==sum1) {
                    count++;
                    sum0=0;
                    sum1=0;
                }
            }
        } else {
            return -1;
        }
        return count;
    }
}
