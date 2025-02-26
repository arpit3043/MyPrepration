package String;
import java.util.Map;
public class RomanToNumeral {
    public static void main(String[] args) {
        String s = "XXIX";
        System.out.println(getIntegerValue(s));
    }
    private static Map<Character, Integer> mapping = Map.ofEntries(
            Map.entry('I', 1),
            Map.entry('V', 5),
            Map.entry('X', 10),
            Map.entry('L', 50),
            Map.entry('C', 100),
            Map.entry('D', 500),
            Map.entry('M', 1000)
    );
    private static int getIntegerValue(String s) {
        int N=s.length();
        if (s.isEmpty()) {
            return 0;
        }
        int value = 0;
        for (int i = 0; i < N; i++) {
            if (i + 1 < s.length() &&
                    mapping.get(s.charAt(i)) < mapping.get(s.charAt(i + 1))) {
                value -= mapping.get(s.charAt(i));
            } else {
                value += mapping.get(s.charAt(i));
            }
        }
        return value;
    }
}