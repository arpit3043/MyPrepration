package String;
public class NextSmallerPalindrome {
    public static void main(String[] args) {
        String s = "12321";
        System.out.println(nextSmallerPalindrome(s));
    }
    private static String nextSmallerPalindrome(String s) {
        int n = s.length();
        int mid = n/2;
        char[] arr = s.toCharArray();
        if (s.length()==1 && s.charAt(0)=='1') {
            return "0";
        }
        for (int i=mid; i<n; i++) {
            int digit = arr[i]-'0';
            if (digit!=0) {
                arr[i] = arr[n-1-i] = (char)((digit-1)+'0');
                break;
            } else {
                arr[i] = arr[n-1-i] = '9';
            }
        }
        if (arr[0]=='0') {
            arr[0] = '9';
            return String.valueOf(arr).substring(0,n-1);
        }
        return String.valueOf(arr);
    }
}