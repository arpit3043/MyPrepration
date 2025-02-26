package String;
public class CheckStringRepetition {
    public static void main(String[] args) {
        String s = "ABCDABCDABCDABCD";
        System.out.println(check(s));
    }
    private static boolean check(String str) {
        int N=str.length();
        if (str == null || N == 0) {
            return false;
        }
        return (str + str).substring(1, 2 * str.length() - 1).contains(str);
    }
}