package String;
public class RemoveAdjacentDuplicate {
    public static void main(String[] args) {
        String s = "AAABBCDDD";
        System.out.println(removeDuplicates(s));
    }
    private static String removeDuplicates(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        char prev = 0;
        int k = 0;
        for (char c: chars) {
            if (prev != c) {
                chars[k++] = c;
                prev = c;
            }
        }
        return new String(chars).substring(0, k);
    }
}