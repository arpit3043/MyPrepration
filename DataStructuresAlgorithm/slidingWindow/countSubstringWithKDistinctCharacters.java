package slidingWindow;
import java.util.HashMap;
import java.util.Map;

public class countSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String str = "aacfssa";
        int K=3;
        System.out.println(countSubStringsWithKDiffChars(str, K));
    }
    private static int countSubStringsWithKDiffChars(String str, int k) {
        return Math.abs((countUptoK(str, k) - countUptoK(str, k - 1)));
    }

    private static int countUptoK(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int num = 0;
        int left = 0;
        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0)- 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            num += i - left + 1;
        }
        return num;
    }
}
