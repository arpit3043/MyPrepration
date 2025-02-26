package String;
public class RemoveOccurencesOfABC {
    public static void main(String[] args) {
        String str = "ABCACBCAABB";
        System.out.printf("The string after removal of 'AB' and 'C' is '%s'", removeOccurencesOfABC(str));
    }
    private static String removeOccurencesOfABC(String str) {
        int N=str.length();
        char[] chars = str.toCharArray();
        int i = 0;
        int k = 0;
        while (i < N) {
            if (chars[i] == 'B' && (k > 0 && chars[k - 1] == 'A')) {
                --k;
                ++i;
            } else if (chars[i] == 'C') {
                ++i;
            } else {
                chars[k++] = chars[i++];
            }
        }
        return new String(chars).substring(0, k);
    }
}