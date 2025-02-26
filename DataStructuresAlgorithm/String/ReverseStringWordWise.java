package String;
import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;
public class ReverseStringWordWise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = reverseStringWordWise(input);
        System.out.println(ans);
    }
    private static String reverseStringWordWise(String input) {
        int N = input.length();
        String result = "";
        String sub;
        int i = 0;
        while (i < N) {
            int j = i;
            while (j < N && input.charAt(j) != ' ') {
                j++;
            }
            sub = substr(input, i, j);
            if (result.length() == 0) {
                result = sub;
            } else {
                result = sub + " " + result;
            }
            i = j + 1;
        }
        return result;
    }

    private static String substr(String input, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i<end; i++) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}