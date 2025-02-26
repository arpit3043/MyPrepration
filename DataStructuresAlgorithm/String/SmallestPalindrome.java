package String;
import java.lang.String;
import java.lang.StringBuilder;
public class SmallestPalindrome {
    public static void main(String[] args) throws Exception {
        String number = "999";
        int length = number.length();
        System.out.println(nextLargestPalindrome(number, length));
    }
    private static String nextLargestPalindrome(String number, int length) {
        int N = number.length();
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[N];
        int i;
        int j;
        int carry;
        int solved =0;
        for(i=0; i<N; i++) {
            nums[i] = number.charAt(i)-'0';
        }
        int n = nums.length;
        for(i=(n+1)/2; i<n; i++) {
            if(nums[i]<nums[n-i-1]) {
                nums[i] = nums[n-i-1];
                for(j=i+1; j<n; j++) {
                    nums[j] = nums[n-j-1];
                }
                solved = 1;
                break;
            } else if(nums[i]>nums[n-i-1]){
                break;
            }
        }
        if(solved == 1) {
            for(i=0; i<n; i++) {
                sb.append(nums[i]);
            }
            return sb.toString();
        }
        carry = 1;
        for(i=(n-1)/2; i>=0; i--) {
            if(nums[i]+carry==10){
                nums[i] =0;
                carry = 1;
            } else{
                nums[i]++;
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            sb.append(1);
        }
        for(i=0;i<n;i++){
            sb.append(nums[i]);
        }
        if(carry == 1){
            n++;
        }
        for(i=(n+1)/2;i<n;i++){
            sb.setCharAt(i, sb.charAt(n-i-1));
        }
        return sb.toString();
    }
}