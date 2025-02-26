package String;
public class SubtractStrings {
    public static void main(String[] args) {
        String first = "abc";
        String second = "ac";
        System.out.println(differenceOfStrings(first, second));
    }
    private static char differenceOfStrings(String first, String second) {
        char c = 0;
        for (char ch: first.toCharArray()) {
            c ^= ch;
        }
        for (char ch: second.toCharArray()) {
            c ^= ch;
        }
        return c;
    }
}