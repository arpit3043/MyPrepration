package String;
import java.lang.String;
import java.lang.StringBuilder;
public class encodeString {
    public static void main(String[] args) throws Exception {
        String str = "aaaaaaaaaabbc";
        System.out.println(encodeString(str));
    }
    private static String encodeString(String message) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char curChar = message.charAt(i);
            int charFreq = 1;
            while (i + 1 < message.length()
                    && message.charAt(i + 1) == curChar) {
                i++;
                charFreq++;
            }
            ans.append(curChar);
            ans.append(charFreq);
        }
        return ans.toString();
    }
}