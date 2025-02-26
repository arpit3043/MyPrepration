package String;
public class MergeAlternatively {
    public static void main(String[] args) throws Exception {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternatelyStrings(word1, word2));
    }

    private static String mergeAlternatelyStrings(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int N = word1.length();
        int M = word2.length();
        while (i < N || i < M) {
            if (i < N) {
                result.append(word1.charAt(i));
            }
            if (i < M) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}