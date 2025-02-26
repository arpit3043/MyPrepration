package String;
import java.util.LinkedList;
import java.util.List;
import java.lang.String;
public class KthInDecryptedString {
    public static void main(String[] args) {
        String str="a2b3cd3";
        long k=8;
        System.out.println(kThCharaterOfDecryptedString(str, k));
    }

    private static char kThCharaterOfDecryptedString(String s, long k) {
        List<String> chars = removeSpace(s.split("\\d"));
        List<String> counts = removeSpace(s.split("\\D"));
        int i = 0;
        long prev = 0;
        k--;
        while (i < chars.size()) {
            long size = chars.get(i).length() * Long.parseLong(counts.get(i));
            if (prev + size >= k) {
                return chars.get(i).charAt((int) ((k - prev) % chars.get(i).length()));
            } else {
                prev += size;
            }
            i++;
        }
        return '$';
    }

    private static List<String> removeSpace(String[] arr) {
        List<String> ans = new LinkedList<>();
        for (String val : arr) {
            if (val.isEmpty() || val.charAt(0) == ' ') {
                continue;
            } else {
                ans.add(val);
            }
        }
        return ans;
    }
}