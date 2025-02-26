package String;
import java.lang.String;
public class PermutationInString {
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "eiabdoo";
        System.out.println(checkInclusion(str1, str2));
    }
    private static boolean checkInclusion(String s1, String s2) {
        int N1 = s1.length();
        int N2 = s2.length();
        int[] data = new int[26];
        int[] test = new int[26];
        if(N1>N2) {
            return false;
        }
        for(char c : s1.toCharArray()) {
            data[c-'a']++;
        }

        for(int i=0; i<N1; i++) {
            test[s2.charAt(i)-'a']++;
        }

        for(int i=0; i<N2-N1; i++) {
            if(equalsString(test, data)) {
                return true;
            }
            test[s2.charAt(i+N1)-'a']++;
            test[s2.charAt(i)-'a']--;
        }
        return equalsString(test, data);
    }

    private static boolean equalsString(int[] s1, int[] s2) {
        for(int i=0; i<26; i++) {
            if(s1[i]!=s2[i]) {
                return false;
            }
        }
        return true;
    }
}