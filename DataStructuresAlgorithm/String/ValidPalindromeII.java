package String;
public class ValidPalindromeII {
    public static void main(String[] args) {
        int N=8;
        String s="AZBCDCBA";
        System.out.println(validPalindrome(N, s));
    }
    private static boolean validPalindrome(int n, String s) {
        int flag=0;
        int i=0;
        int j=n-1;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            } else if(s.charAt(i)==s.charAt(j-1)) {
                flag++;
                j--;
            } else if(s.charAt(i+1)==s.charAt(j)) {
                flag++;
                i++;
            } else {
                return false;
            }
        }
        return flag <= 1;
    }
}