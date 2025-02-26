package String;
public class LongestPalindromeInString {
    public static void main(String[] args) {
        String S = "aaaabbaa";
        System.out.println(longestPalindromeString(S));
    }
    private static String longestPalindromeString(String S){
        int a=0;
        int b=1;
        int max=1;
        int N = S.length();
        for(int i=0; i<N; i++) {
            for(int j=N-1; j>i; j--) {
                if(j-i+1>max && checkPalindrome(S,i,j)){
                    a=i;
                    b=j+1;
                    max=j-i+1;
                    break;
                }
            }
        }
        return S.substring(a,b);
    }

    private static boolean checkPalindrome(String str,int i,int j) {
        while(i<j) {
            if(str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}