package String;
public class FirstPalindrome {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }

    private static String firstPalindrome(String[] words) {
        int n=words.length;
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (isPalindrome(word)) {
                sb.append(word);
                break;
            }
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String str) {
        int n=str.length();
        for(int i=0; i<n/2; i++) {
            if(str.charAt(i)!=str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }
}