package String;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "add";
        String t = "egg";
        System.out.println(isBothStringsIsomorphicStrings(s, t));
    }
    private static boolean isBothStringsIsomorphicStrings(String str1,String str2) {
        int N = str1.length();
        int M = str2.length();
        if(N!=M) {
            return false;
        }
        return areIsomorphicHelper(str1, str2) && areIsomorphicHelper(str2, str1);
    }
    private static boolean areIsomorphicHelper(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            if(!map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), str2.charAt(i));
            } else {
                if(map.get(str1.charAt(i))!=str2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}