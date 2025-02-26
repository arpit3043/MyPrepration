package String;
public class SearchWordInSentence {
    public static void main(String[] args) {
        String s="coding is fun";
        String w="not";
        System.out.println(findWord(s,w));
    }
    private static boolean findWord(String sentence, String word) {
        String[] words = sentence.split(" ");
        for (String w : words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
}